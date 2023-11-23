package com.example.demo.repositorio;

import com.example.demo.Entidad.clientes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteCrudRepository extends CrudRepository<clientes,Integer> {
    List<clientes> findByNomCliente(String nomCliente);
    @Transactional
    @Modifying
    @Query(value = "UPDATE clientes SET nomCliente=:nomCliente WHERE cc_clientes=:cc_clientes", nativeQuery = true)
    void actualizarClientes(@Param("nomCliente") String nomCliente, @Param("cc_clientes") Integer cc_clientes);

}


