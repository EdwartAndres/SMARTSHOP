package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.Entidad.Inventario;
import com.example.demo.repositorio.InventarioCrudRepository;

import java.util.List;

@Service
public class InventarioServicio {

    private InventarioCrudRepository inventarioCrudRepository;

    public InventarioServicio(InventarioCrudRepository inventarioCrudRepository) {
        this.inventarioCrudRepository = inventarioCrudRepository;
    }

    public Inventario obtenerInventarioPorID(Integer idProducto) {
        return inventarioCrudRepository.findById(idProducto).orElse(null);
    }

    public List<Inventario> listarInventario() {
        return (List<Inventario>) inventarioCrudRepository.findAll();
    }

    public Inventario guardarInventario(Inventario inventario) {
        return inventarioCrudRepository.save(inventario);
    }

    public void eliminarInventario(Integer idProducto) {
        inventarioCrudRepository.deleteById(idProducto);
    }

    // Puedes agregar otros métodos según tus necesidades
}