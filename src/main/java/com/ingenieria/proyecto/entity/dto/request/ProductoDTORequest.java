package com.ingenieria.proyecto.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTORequest implements Serializable {
    @NotBlank(message = "No debe estar vacío!")
    private String nombre;

    @NotNull
    private BigDecimal precio_unitario;

    @NotNull
    private Integer cantidad;

    @NotBlank(message = "No debe estar vacío!")
    private String descripcion;
}
