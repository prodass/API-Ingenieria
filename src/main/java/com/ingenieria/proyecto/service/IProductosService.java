package com.ingenieria.proyecto.service;

import com.ingenieria.proyecto.entity.Producto;
import com.ingenieria.proyecto.entity.dto.ProductoDTO;
import com.ingenieria.proyecto.entity.dto.ProductoDTOReq;

import java.util.List;
import java.util.Optional;

public interface IProductosService {
    public List<ProductoDTO> listarProductos();
    public ProductoDTO listarProductoPorCodigo(String codigo);
    public ProductoDTO guardarProducto(ProductoDTOReq productoReq);
    public ProductoDTO actualizarProducto(String codigo, ProductoDTOReq productoReq);
    public void eliminarProducto(String codigo);
}
