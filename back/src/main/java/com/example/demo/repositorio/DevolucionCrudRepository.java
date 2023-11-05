package com.example.demo.repositorio;
import com.example.demo.Entidad.devoluciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevolucionCrudRepository extends JpaRepository<devoluciones, Long> {
}

