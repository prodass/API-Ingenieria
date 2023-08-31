package com.ingenieria.proyecto.controller;

import com.ingenieria.proyecto.entity.dto.request.ProductoDTORequest;
import com.ingenieria.proyecto.service.IProductosService;
import com.ingenieria.proyecto.util.GenericConstant;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(GenericConstant.RESOURCE_GENERIC)
@Tag(name = "Gestión de recursos privados de sofas (Api panel de administrador)")
public class ProductoController {
    @Autowired
    private IProductosService productosService;

    @GetMapping(GenericConstant.RESOURCE_PRODUCTOS)
    public ResponseEntity<?> listarProductos(){
        return ResponseEntity.ok().body(this.productosService.listarProductos());
    }

    @GetMapping(GenericConstant.RESOURCE_PRODUCTOS_CODIGO)
    public ResponseEntity<?> listarProductoPorCodigo(@PathVariable String codigo){
        return ResponseEntity.ok().body(this.productosService.listarProductoPorCodigo(codigo));
    }

    @PostMapping(GenericConstant.RESOURCE_PRODUCTOS)
    public ResponseEntity<?> guardarProducto(@Valid @RequestPart("producto") ProductoDTORequest productoDTORequest,
                                                               @NotNull @RequestPart("imagen") MultipartFile imagen_principal){

        return ResponseEntity.ok().body(this.productosService.guardarProducto(productoDTORequest));
    }

    @PutMapping(GenericConstant.RESOURCE_PRODUCTOS_CODIGO)
    public ResponseEntity<?> actualizarProducto(@PathVariable String codigo, @RequestBody ProductoDTORequest productoDTORequest){
        return ResponseEntity.ok().body(this.productosService.actualizarProducto(codigo, productoDTORequest));
    }

    @DeleteMapping(GenericConstant.RESOURCE_PRODUCTOS)
    public ResponseEntity<?> eliminarProducto(@PathVariable String codigo){

        this.productosService.eliminarProducto(codigo);

        return ResponseEntity.ok().build();
    }
}
