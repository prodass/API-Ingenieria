package com.ingenieria.proyecto.controller;

import com.ingenieria.proyecto.entity.Producto;
import com.ingenieria.proyecto.entity.dto.ProductoDTO;
import com.ingenieria.proyecto.entity.dto.ProductoDTOReq;
import com.ingenieria.proyecto.service.IProductosService;
import com.ingenieria.proyecto.util.GenericConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(GenericConstant.RESOURCE_GENERIC)
@CrossOrigin("*")
public class ProductoController {
    @Autowired
    private IProductosService productosService;

    @GetMapping(GenericConstant.RESOURCE_PRODUCTOS)
    public ResponseEntity<List<ProductoDTO>> listarProductos(){
        return new ResponseEntity<List<ProductoDTO>>(this.productosService.listarProductos(), HttpStatus.OK);
    }

    @GetMapping(GenericConstant.RESOURCE_PRODUCTOS_SEARCH)
    public ResponseEntity<ProductoDTO> listarProductoPorCodigo(@PathVariable String codigo){
        return new ResponseEntity<ProductoDTO>(this.productosService.listarProductoPorCodigo(codigo), HttpStatus.OK);
    }

    @PostMapping(GenericConstant.RESOURCE_PRODUCTOS)
    public ResponseEntity<ProductoDTO> guardarProducto(@RequestBody ProductoDTOReq productoDTOReq){
        return new ResponseEntity<ProductoDTO>(this.productosService.guardarProducto(productoDTOReq),HttpStatus.CREATED);
    }

    @PutMapping(GenericConstant.RESOURCE_PRODUCTOS_SEARCH)
    public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable String codigo, @RequestBody ProductoDTOReq productoDTOReq){
        return new ResponseEntity<ProductoDTO>(this.productosService.actualizarProducto(codigo, productoDTOReq),HttpStatus.OK);
    }

    @DeleteMapping(GenericConstant.RESOURCE_PRODUCTOS)
    public ResponseEntity<String> eliminarProducto(@PathVariable String codigo){
        this.productosService.eliminarProducto(codigo);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}
