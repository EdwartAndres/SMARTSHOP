package com.example.demo.repositorio;
import com.example.demo.Entidad.productos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<productos,Integer> {
    List<productos> findByNomProducto(String nomProducto);

}

