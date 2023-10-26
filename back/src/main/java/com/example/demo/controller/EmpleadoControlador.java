package com.example.demo.controller;
import com.example.demo.Entidad.clientes;
import com.example.demo.Entidad.empleados;
import com.example.demo.service.ClienteServicio;
import com.example.demo.service.EmpleadoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EmpleadoControlador {
    private EmpleadoServicio empleadoServicio;

    public EmpleadoControlador(EmpleadoServicio empleadoServicio) {
        this.empleadoServicio = empleadoServicio;
    }

    @PostMapping("/insertarem")
    public ResponseEntity<Void>insertarempleados(@RequestBody empleados Empleados){
        if (empleadoServicio.empleadosPorCC(Empleados.getCc_Empleado())!=null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } else {
            empleadoServicio.insertarempleados(Empleados);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @GetMapping("/listarem")
    public ResponseEntity<List<empleados>>listarEmpleados(){
        return new ResponseEntity<>(empleadoServicio.listaempleados(), HttpStatus.OK);

    }
    @GetMapping("/unicoem/{cc_Empleado}")
    public ResponseEntity<empleados>empleadosPorCC(@PathVariable Integer cc_Empleado){
        return new ResponseEntity<>(empleadoServicio.empleadosPorCC(cc_Empleado),HttpStatus.OK);
        }

    @DeleteMapping("/eliminarem/{cc_Empleado}")
    public ResponseEntity<Void> eliminarEmpleados(@PathVariable Integer cc_Empleado){
        if(empleadoServicio.empleadosPorCC(cc_Empleado)!=null){
            empleadoServicio.eliminarEmpleados(cc_Empleado);
            return new ResponseEntity<>(HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND)
                ;
    }






    @PutMapping("/actualizarem/{cc_Empleado}")
    public ResponseEntity<Void> actualizarEmpleados(@RequestBody empleados Empleados){
        if(empleadoServicio.empleadosPorCC(Empleados.getCc_Empleado())!=null){
            empleadoServicio.actualizarEmpleados(Empleados);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/actualizaremSave")
    public ResponseEntity<Void> actualizarEmpleadosemSave(@RequestBody empleados Empleados){
        if(empleadoServicio.empleadosPorCC(Empleados.getCc_Empleado())!=null){
            empleadoServicio.insertarempleados(Empleados);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}





