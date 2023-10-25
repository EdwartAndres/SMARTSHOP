package com.example.demo.controller;

import com.example.demo.Entidad.detalles;
import com.example.demo.Entidad.productos;
import com.example.demo.service.DetallesServicio;
import com.example.demo.service.ProductoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DetallesControlador {
    private DetallesServicio detallesServicio;

    public DetallesControlador(DetallesServicio detallesServicio) {
        this.detallesServicio = detallesServicio;
    }


    @GetMapping("/listardetalles")
    public ResponseEntity<List<detalles>>listardetalles(){
        return new ResponseEntity<>(detallesServicio.listardetalles(), HttpStatus.OK);

    }
    @GetMapping("/unicodetallecod/{cod_Identificacion}")
    public ResponseEntity<detalles>detallesPorCD(@PathVariable Integer cod_Identificacion){
        return new ResponseEntity<>(detallesServicio.detallesPorCD(cod_Identificacion),HttpStatus.OK);
        }

    @GetMapping("/unicodetallesprecio/{precio}")
    public  ResponseEntity <List<detalles>> DetallesPorPrecio(@PathVariable ("precio") int precio){
        return  new ResponseEntity<>(detallesServicio.DetallesPorPrecio(precio),HttpStatus.OK);
    }
    @PostMapping("/agregarDetalle")
    public String agregarDetalles(@RequestBody detalles detalle ){
        return detallesServicio.agregarDetalles(detalle);
    }

}






