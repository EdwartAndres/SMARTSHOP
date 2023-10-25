package com.example.demo.repositorio;
import com.example.demo.Entidad.detalles;
import com.example.demo.Entidad.pedidos_productos;
import com.example.demo.Entidad.productos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PedidoProductoCrudRepository extends CrudRepository<pedidos_productos,Integer> {
    List<pedidos_productos> findByCod(Integer cod);
}

