package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entidad.Proveedor;
import com.example.demo.service.ProveedorServicio;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProveedorControlador {
    private ProveedorServicio proveedorServicio;

    public ProveedorControlador(ProveedorServicio proveedorServicio) {
        this.proveedorServicio = proveedorServicio;
    }

    @PostMapping("/insertarproveedor")
    public ResponseEntity<String> insertarProveedor(@RequestBody Proveedor proveedor) {
        proveedorServicio.insertarProveedor(proveedor);
        return new ResponseEntity<>("Proveedor Registrado", HttpStatus.CREATED);
    }

    @GetMapping("/listarproveedores")
    public ResponseEntity<List<Proveedor>> listarProveedores() {
        List<Proveedor> proveedores = proveedorServicio.listarProveedores();
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    @GetMapping("/unicoproveedor/{RUT}")
    public ResponseEntity<Proveedor> proveedorPorRUT(@PathVariable Integer RUT) {
        Proveedor proveedor = proveedorServicio.proveedorPorRUT(RUT);
        if (proveedor != null) {
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombreproveedor/{nombre}")
    public ResponseEntity<List<Proveedor>> proveedorPorNombre(@PathVariable String nombre) {
        List<Proveedor> proveedores = proveedorServicio.proveedorPorNombre(nombre);
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarproveedor/{RUT}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Integer RUT) {
        Proveedor proveedor = proveedorServicio.proveedorPorRUT(RUT);
        if (proveedor != null) {
            proveedorServicio.eliminarProveedor(RUT);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizarproveedor")
    public ResponseEntity<Void> actualizarProveedor(@RequestBody Proveedor proveedor) {
        Proveedor existingProveedor = proveedorServicio.proveedorPorRUT(proveedor.getRut());
        if (existingProveedor != null) {
            proveedorServicio.actualizarProveedor(proveedor);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}