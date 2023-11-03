package com.example.demo.controller;

import com.example.demo.Entidad.comprar;
import com.example.demo.Entidad.pedidos_productos;
import com.example.demo.Entidad.Producto;
import com.example.demo.service.ComprarServicio;
import com.example.demo.service.ProductoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class ComprarControlador {
    private ComprarServicio comprarServicio;

    public ComprarControlador(ComprarServicio comprarServicio) {
        this.comprarServicio = comprarServicio;
    }


    @GetMapping("/listarcomprar")
    public ResponseEntity<List<comprar>>listarcomprar(){
        return new ResponseEntity<>(comprarServicio.listarcomprar(), HttpStatus.OK);

    }
    @GetMapping("/unicocomprarcod/{cod_Compra}")
    public ResponseEntity<comprar>comprarPorCD(@PathVariable Integer cod_Compra){
        return new ResponseEntity<>(comprarServicio.comprarPorCD(cod_Compra),HttpStatus.OK);
        }

    @GetMapping("/unicocomprarmetodo/{metodoPago}")
    public  ResponseEntity <List<comprar>> ComprarPorMetodopago(@PathVariable ("metodoPago") String metodoPago){
        return  new ResponseEntity<>(comprarServicio.ComprarPorMetodopago(metodoPago),HttpStatus.OK);
    }
    @PostMapping("/agregarCompras")
    public String agregarCompras(@RequestBody comprar Compras ){
        return comprarServicio.agregarCompras(Compras);
    }

}






