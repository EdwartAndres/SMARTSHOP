package com.example.demo.service;

import com.example.demo.Entidad.Producto;
import com.example.demo.repositorio.ProductoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoCrudRepository productoRepository;

    // Obtener todos los productos
    public List<Producto> obtenerTodosLosProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    // Obtener un producto por ID
    public Producto obtenerProductoPorId(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    // Guardar un nuevo producto
    public Producto guardarProducto(Producto producto) {
        // Aquí puedes realizar validaciones u otras operaciones antes de guardar
        return productoRepository.save(producto);
    }
    public List<Producto> obtenerProductoPorNombre(String nombre) {
        return productoRepository.findByNombreContaining(nombre);
    }


    // Eliminar un producto por ID
    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }
}