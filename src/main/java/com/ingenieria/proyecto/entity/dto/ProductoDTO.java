package com.ingenieria.proyecto.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO implements Serializable {
    private String codigo;
    private String nombre;
    private BigDecimal precio_unitario;
    private Integer cantidad;
    private String descripcion;
}
