package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.Entidad.Proveedor;
import com.example.demo.repositorio.ProveedorCrudRepository;

import java.util.List;

@Service
public class ProveedorServicio {

    private ProveedorCrudRepository proveedorCrudRepository;

    public ProveedorServicio(ProveedorCrudRepository proveedorCrudRepository) {
        this.proveedorCrudRepository = proveedorCrudRepository;
    }

    public Proveedor proveedorPorRUT(Integer RUT) {
        if (proveedorCrudRepository.findById(RUT).isPresent()) {
            return proveedorCrudRepository.findById(RUT).get();
        } else {
            return null;
        }
    }

    public List<Proveedor> listarProveedores() {
        return (List<Proveedor>) proveedorCrudRepository.findAll();
    }

    public List<Proveedor> proveedorPorNombre(String nombre) {
        return proveedorCrudRepository.findByNombre(nombre);
    }

    public String insertarProveedor(Proveedor proveedor) {
        proveedorCrudRepository.save(proveedor);
        return "Proveedor Registrado";
    }

    public void eliminarProveedor(Integer RUT) {
        proveedorCrudRepository.deleteById(RUT);
    }

    public void actualizarProveedor(Proveedor proveedor) {
        proveedorCrudRepository.save(proveedor);
    }
}