package com.example.demo.repositorio;

import com.example.demo.Entidad.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
