package com.example.demo.controller;
import com.example.demo.Entidad.clientes;
import com.example.demo.Entidad.distribuidores;
import com.example.demo.service.ClienteServicio;
import com.example.demo.service.DistribuidorServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@CrossOrigin("*")
@RestController
public class DistribuidoresControlador {
    private DistribuidorServicio distribuidorServicio;

    public DistribuidoresControlador(DistribuidorServicio distribuidorServicio) {
        this.distribuidorServicio = distribuidorServicio;
    }

    @PostMapping("/insertardis")
    public ResponseEntity<Void>insertardistribuidores(@RequestBody distribuidores Distribuidores){
        System.out.println(Distribuidores.getNitDistribuidor());
        if (distribuidorServicio.distribuidoresPorCC(Distribuidores.getNitDistribuidor())!=null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } else {
            distribuidorServicio.insertardistribuidores(Distribuidores);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @GetMapping("/listardis")
    public ResponseEntity<List<distribuidores>>listarDistribuidores(){
        return new ResponseEntity<>(distribuidorServicio.listaDistribuidores(), HttpStatus.OK);

    }
    @GetMapping("/unicodis/{Nit_Distribuidor}")
    public ResponseEntity<distribuidores>distribuidorPorCC(@PathVariable Integer Nit_Distribuidor){
        return new ResponseEntity<>(distribuidorServicio.distribuidoresPorCC(Nit_Distribuidor),HttpStatus.OK);
        }

    @GetMapping("/nombredis/{nombredis}")
    public ResponseEntity<List<distribuidores>> distribuidorPorNombre(@PathVariable String nombredis) {
        return new ResponseEntity<>(distribuidorServicio.nombreDistribuidores(nombredis), HttpStatus.OK);
    }
    @DeleteMapping("/eliminardis/{Nit_Distribuidor}")
    public ResponseEntity<Void> eliminarDistribuidores(@PathVariable Integer Nit_Distribuidor){
        if(distribuidorServicio.distribuidoresPorCC(Nit_Distribuidor)!=null){
            distribuidorServicio.eliminarDistribuidores(Nit_Distribuidor);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizardisSave")
    public ResponseEntity<Void> actualizardisDistribuidorSave(@RequestBody distribuidores Distribuidores){
        if(distribuidorServicio.distribuidoresPorCC(Distribuidores.getNitDistribuidor())!=null){
            distribuidorServicio.insertardistribuidores(Distribuidores);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}





