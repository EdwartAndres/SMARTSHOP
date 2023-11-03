package com.example.demo.repositorio;
import com.example.demo.Entidad.comprar;
import com.example.demo.Entidad.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComprarCrudRepository extends CrudRepository<comprar,Integer> {
    List<comprar> findByMetodoPago(String metodoPago);
}

