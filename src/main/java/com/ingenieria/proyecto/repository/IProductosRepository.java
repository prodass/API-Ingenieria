package com.ingenieria.proyecto.repository;

import com.ingenieria.proyecto.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductosRepository extends JpaRepository<Producto, Integer> {
    public Optional<Producto> findByCodigo(String codigo);
}
