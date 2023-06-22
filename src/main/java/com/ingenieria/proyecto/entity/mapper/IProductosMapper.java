package com.ingenieria.proyecto.entity.mapper;

import com.ingenieria.proyecto.entity.Producto;
import com.ingenieria.proyecto.entity.dto.ProductoDTO;
import com.ingenieria.proyecto.entity.dto.ProductoDTOReq;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true))
public interface IProductosMapper {
    ProductoDTO toDto(Producto producto);
    Producto toEntityFromDTO(ProductoDTO productoDTO);
    Producto toEntityFromDTOReq(ProductoDTOReq productoReq);
}
