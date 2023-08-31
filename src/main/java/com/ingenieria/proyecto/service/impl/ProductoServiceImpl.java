package com.ingenieria.proyecto.service.impl;

import com.ingenieria.proyecto.entity.Producto;
import com.ingenieria.proyecto.entity.dto.request.ProductoDTORequest;
import com.ingenieria.proyecto.entity.dto.response.ProductoDTOResponse;
import com.ingenieria.proyecto.entity.mapper.IProductosMapper;
import com.ingenieria.proyecto.repository.IProductosRepository;
import com.ingenieria.proyecto.service.IProductosService;
import com.ingenieria.proyecto.util.GenericUtil;
import com.ingenieria.proyecto.util.errorHandler.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements IProductosService {
    @Autowired
    private IProductosRepository productosRepository;

    @Autowired
    private IProductosMapper productosMapper;

    @Autowired
    private GenericUtil genericUtil;

    private ModelMapper modelMapper;

    public ProductoServiceImpl(){
        // Configurar ModelMapper
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setPropertyCondition(context -> context.getSource() != null);
    }

    @Override
    public List<ProductoDTOResponse> listarProductos() {

        return this.productosMapper.toDto(
                this.productosRepository.findAll()
        );
    }

    @Override
    public ProductoDTOResponse listarProductoPorCodigo(String codigo) {
        Producto producto = this.productosRepository.findByCodigo(codigo)
                .orElseThrow(() -> new EntityNotFoundException("codigo:No existe un producto con ese código!"));

        return this.productosMapper.toDto(producto);
    }

    @Override
    public ProductoDTOResponse guardarProducto(ProductoDTORequest productoReq) {
        Producto producto = this.productosMapper.toEntityFromDTOReq(productoReq);

        producto.setCodigo(this.genericUtil.codigoGenerado("P"));

        return this.productosMapper.toDto(
                this.productosRepository.save(producto)
        );
    }

    @Override
    public ProductoDTOResponse actualizarProducto(String codigo, ProductoDTORequest productoReq) {
        Producto productoExistente = this.productosRepository.findByCodigo(codigo)
                .orElseThrow(() -> new EntityNotFoundException("codigo:No existe un producto con ese código!"));

        modelMapper.map(productoReq, productoExistente);

        this.productosRepository.save(productoExistente);

        return this.productosMapper.toDto(productoExistente);
    }

    @Override
    public void eliminarProducto(String codigo) {
        ProductoDTOResponse producto = listarProductoPorCodigo(codigo);

        this.productosRepository.delete(this.productosMapper.toEntityFromDTO(producto));
    }
}
