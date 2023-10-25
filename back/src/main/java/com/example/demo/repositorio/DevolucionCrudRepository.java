package com.example.demo.repositorio;
import com.example.demo.Entidad.devoluciones;
import com.example.demo.Entidad.productos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DevolucionCrudRepository extends CrudRepository<devoluciones,Integer> {
    List<devoluciones> findByUnidades(int unidades);
}

