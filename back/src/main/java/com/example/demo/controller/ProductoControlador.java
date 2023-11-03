package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entidad.Producto;
import com.example.demo.service.ProductoServicio;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProductoControlador {
    private ProductoServicio productoServicio;

    public ProductoControlador(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<Producto> obtenerProductoPorID(@PathVariable Integer idProducto) {
        Producto producto = productoServicio.obtenerProductoPorID(idProducto);
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/listarproductos")
    public ResponseEntity<List<Producto>> listarProductos() {
        List<Producto> productos = productoServicio.listarProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @PostMapping("/guardarproducto")
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoServicio.guardarProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminarproducto/{idProducto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Integer idProducto) {
        productoServicio.eliminarProducto(idProducto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}




