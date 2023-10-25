package com.example.demo.controller;

import com.example.demo.Entidad.devoluciones;
import com.example.demo.Entidad.pedidos_productos;
import com.example.demo.Entidad.productos;
import com.example.demo.service.DevolucionServicio;
import com.example.demo.service.ProductoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DevolucionControlador {
    private DevolucionServicio devolucionServicio;

    public DevolucionControlador(DevolucionServicio devolucionServicio) {
        this.devolucionServicio = devolucionServicio;
    }


    @GetMapping("/listardevoluciones")
    public ResponseEntity<List<devoluciones>>listardevoluciones(){
        return new ResponseEntity<>(devolucionServicio.listardevoluciones(), HttpStatus.OK);

    }
    @GetMapping("/unicodevol/{cod_Devolucion}")
    public ResponseEntity<devoluciones>devolucionPorCD(@PathVariable Integer cod_Devolucion){
        return new ResponseEntity<>(devolucionServicio.devolucionPorCD(cod_Devolucion),HttpStatus.OK);
        }

    @GetMapping("/unicodevoluciones/{unidades}")
    public  ResponseEntity <List<devoluciones>> devolucionporUnidad(@PathVariable ("unidades") int unidades){
        return  new ResponseEntity<>(devolucionServicio.devolucionporUnidad(unidades),HttpStatus.OK);
    }
    @PostMapping("/agregarDevolucion")
    public String agregarDevolucion(@RequestBody devoluciones Devoluciones ){
        return devolucionServicio.agregarDevolucion(Devoluciones);
    }
}






