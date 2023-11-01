package com.example.demo.repositorio;
import com.example.demo.Entidad.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioCrudRepository extends JpaRepository<usuario, Long> {
    // Puedes definir consultas personalizadas aquí si es necesario
}
