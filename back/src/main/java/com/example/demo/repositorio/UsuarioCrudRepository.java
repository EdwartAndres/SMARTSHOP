package com.example.demo.repositorio;

import com.example.demo.Entidad.usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioCrudRepository extends CrudRepository<usuario, Long> {
    static usuario findByEmail(String email) {
        return null;
    }
}