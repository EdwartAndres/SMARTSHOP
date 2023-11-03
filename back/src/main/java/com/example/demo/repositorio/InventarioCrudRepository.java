package com.example.demo.repositorio;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.Entidad.Inventario;

public interface InventarioCrudRepository extends CrudRepository<Inventario, Integer> {
}