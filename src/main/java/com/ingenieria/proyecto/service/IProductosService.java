package com.ingenieria.proyecto.service;

import com.ingenieria.proyecto.entity.dto.request.ProductoDTORequest;
import com.ingenieria.proyecto.entity.dto.response.ProductoDTOResponse;

import java.util.List;

public interface IProductosService {
    public List<ProductoDTOResponse> listarProductos();
    public ProductoDTOResponse listarProductoPorCodigo(String codigo);
    public ProductoDTOResponse guardarProducto(ProductoDTORequest productoReq);
    public ProductoDTOResponse actualizarProducto(String codigo, ProductoDTORequest productoReq);
    public void eliminarProducto(String codigo);
}
