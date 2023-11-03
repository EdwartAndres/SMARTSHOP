package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.Entidad.Producto;
import com.example.demo.repositorio.ProductoCrudRepository;

import java.util.List;

@Service
public class ProductoServicio {

    private ProductoCrudRepository productoCrudRepository;

    public ProductoServicio(ProductoCrudRepository productoCrudRepository) {
        this.productoCrudRepository = productoCrudRepository;
    }

    public Producto obtenerProductoPorID(Integer idProducto) {
        return productoCrudRepository.findById(idProducto).orElse(null);
    }

    public List<Producto> listarProductos() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public Producto guardarProducto(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    public void eliminarProducto(Integer idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }

    // Puedes agregar otros métodos según tus necesidades
}