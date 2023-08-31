package com.ingenieria.proyecto.entity;

import com.ingenieria.proyecto.util.GenericConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = GenericConstant.TAB_NAME_PRODUCTOS, schema = GenericConstant.SCHEMA_NAME)
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id;
    private String nombre;
    private String codigo;
    private BigDecimal precio_unitario;
    private Integer cantidad;
    private String descripcion;
}
