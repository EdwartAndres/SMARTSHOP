package com.example.demo.repositorio;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Entidad.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

}

