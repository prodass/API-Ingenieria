package com.ingenieria.proyecto.service.impl;

import com.ingenieria.proyecto.entity.Producto;
import com.ingenieria.proyecto.entity.dto.ProductoDTO;
import com.ingenieria.proyecto.entity.dto.ProductoDTOReq;
import com.ingenieria.proyecto.entity.mapper.IProductosMapper;
import com.ingenieria.proyecto.repository.IProductosRepository;
import com.ingenieria.proyecto.service.IProductosService;
import com.ingenieria.proyecto.util.errorHandler.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements IProductosService {
    @Autowired
    private IProductosRepository productosRepository;

    @Autowired
    private IProductosMapper productosMapper;

    private ModelMapper modelMapper;

    public ProductoServiceImpl(){
        // Configurar ModelMapper
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setPropertyCondition(context -> context.getSource() != null);
    }

    @Override
    public List<ProductoDTO> listarProductos() {
        List<Producto> productos = this.productosRepository.findAll();

        return productos.stream()
                .map((bean) -> this.productosMapper.toDto(bean))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO listarProductoPorCodigo(String codigo) {
        Producto producto = this.productosRepository.findByCodigo(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));
        return this.productosMapper.toDto(producto);
    }

    @Override
    public ProductoDTO guardarProducto(ProductoDTOReq productoReq) {
        Producto producto = this.productosRepository.save(this.productosMapper.toEntityFromDTOReq(productoReq));
        return this.productosMapper.toDto(producto);
    }

    @Override
    public ProductoDTO actualizarProducto(String codigo, ProductoDTOReq productoReq) {
        Producto productoExistente = this.productosRepository.findByCodigo(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        modelMapper.map(productoReq, productoExistente);

        this.productosRepository.save(productoExistente);

        return this.productosMapper.toDto(productoExistente);
    }

    @Override
    public void eliminarProducto(String codigo) {
        ProductoDTO producto = listarProductoPorCodigo(codigo);

        this.productosRepository.delete(this.productosMapper.toEntityFromDTO(producto));
    }
}
