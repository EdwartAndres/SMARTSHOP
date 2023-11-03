package com.example.demo.repositorio;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.example.demo.Entidad.Proveedor;

import java.util.List;

public interface ProveedorCrudRepository extends CrudRepository<Proveedor, Integer> {
    List<Proveedor> findByNombre(String nombre);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Proveedores SET Nombre = :nombre WHERE RUT = :rut", nativeQuery = true)
    void actualizarProveedor(@Param("nombre") String nombre, @Param("rut") Integer rut);
}