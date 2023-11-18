package com.example.demo.service;
import org.springframework.stereotype.Service;
import com.example.demo.Entidad.Producto;
import com.example.demo.repositorio.ProductoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoCrudRepository productoRepository;

    public List<Producto> getAllProductos() {
        return (List<Producto>) productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(Long id) {
        return productoRepository.findById(Math.toIntExact(id));
    }

    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateProducto(Long id, Producto producto) {
        if (productoRepository.existsById(Math.toIntExact(id))) {
            producto.setId(Math.toIntExact(id));
            return productoRepository.save(producto);
        }
        return null; // Manejar el caso en que el producto no exista
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(Math.toIntExact(id));
    }
}