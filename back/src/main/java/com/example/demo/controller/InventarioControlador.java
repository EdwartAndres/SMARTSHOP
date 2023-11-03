package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entidad.Inventario;
import com.example.demo.service.InventarioServicio;

import java.util.List;

@CrossOrigin("*")
@RestController
public class InventarioControlador {
    private InventarioServicio inventarioServicio;

    public InventarioControlador(InventarioServicio inventarioServicio) {
        this.inventarioServicio = inventarioServicio;
    }

    @GetMapping("/inventario/{idProducto}")
    public ResponseEntity<Inventario> obtenerInventarioPorID(@PathVariable Integer idProducto) {
        Inventario inventario = inventarioServicio.obtenerInventarioPorID(idProducto);
        if (inventario != null) {
            return new ResponseEntity<>(inventario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/listarinventario")
    public ResponseEntity<List<Inventario>> listarInventario() {
        List<Inventario> inventarios = inventarioServicio.listarInventario();
        return new ResponseEntity<>(inventarios, HttpStatus.OK);
    }

    @PostMapping("/guardarinventario")
    public ResponseEntity<Inventario> guardarInventario(@RequestBody Inventario inventario) {
        Inventario nuevoInventario = inventarioServicio.guardarInventario(inventario);
        return new ResponseEntity<>(nuevoInventario, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminarinventario/{idProducto}")
    public ResponseEntity<Void> eliminarInventario(@PathVariable Integer idProducto) {
        inventarioServicio.eliminarInventario(idProducto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}