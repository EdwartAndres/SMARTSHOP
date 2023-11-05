package com.example.demo.repositorio;

import com.example.demo.Entidad.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoCrudRepository extends JpaRepository<Pedido, Long> {
}

