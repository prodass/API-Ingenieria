package com.ingenieria.proyecto.entity.mapper;

import com.ingenieria.proyecto.entity.Producto;
import com.ingenieria.proyecto.entity.dto.request.ProductoDTORequest;
import com.ingenieria.proyecto.entity.dto.response.ProductoDTOResponse;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true))
public interface IProductosMapper {
    ProductoDTOResponse toDto(Producto producto);
    List<ProductoDTOResponse> toDto(List<Producto> producto);

    Producto toEntityFromDTO(ProductoDTOResponse productoDTOResponse);
    Producto toEntityFromDTOReq(ProductoDTORequest productoReq);
}
