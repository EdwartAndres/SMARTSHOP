package com.example.demo.repositorio;
import com.example.demo.Entidad.empleados;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpleadoCrudRepository extends CrudRepository<empleados,Integer> {
    List<empleados> findByNomEmpleado(String Nom_Empleado);
    @Transactional
    @Modifying
    @Query(value = "UPDATE empleados SET Nom_Empleado=:Nom_Empleado,Salario_Empleado=:Salario_Empleado,Horario=:Horario,Cargo=:Cargo  WHERE cc_Empleado=:cc_Empleado", nativeQuery = true)
    void actualizarEmpleados(@Param("Nom_Empleado") String Nom_Empleado, @Param("Salario_Empleado")int Salario_Empleado,@Param("Horario") String Horario,@Param("Cargo") String Cargo,@Param("cc_Empleado") Integer cc_Empleado);

}


