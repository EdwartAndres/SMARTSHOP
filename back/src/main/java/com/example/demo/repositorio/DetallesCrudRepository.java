package com.example.demo.repositorio;
import com.example.demo.Entidad.detalles;
import com.example.demo.Entidad.productos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetallesCrudRepository extends CrudRepository<detalles,Integer> {
    List<detalles> findByPrecio(int precio);
}

