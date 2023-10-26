package com.example.demo.controller;
import com.example.demo.Entidad.empleados;
import com.example.demo.Entidad.pedidos;
import com.example.demo.Entidad.pedidos_productos;
import com.example.demo.service.EmpleadoServicio;
import com.example.demo.service.PedidoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@CrossOrigin("*")
@RestController
public class PedidoControlador {
    private PedidoServicio pedidoServicio;

    public PedidoControlador(PedidoServicio pedidoServicio) {
        this.pedidoServicio = pedidoServicio;
    }


    @GetMapping("/listarpd")
    public ResponseEntity<List<pedidos>>listarpedidos(){
        return new ResponseEntity<>(pedidoServicio.listarpedidos(), HttpStatus.OK);

    }
    @GetMapping("/unicopd/{cod_Pedido}")
    public ResponseEntity<pedidos>pedidosPorCD(@PathVariable Integer cod_Pedido){
        return new ResponseEntity<>(pedidoServicio.pedidosPorCD(cod_Pedido),HttpStatus.OK);
        }

    @GetMapping("/unicocs/{pedidocosto}")
    public  ResponseEntity<List<pedidos>> PedidoPorCosto(@PathVariable ("pedidocosto") int costoNeto){
        return  new ResponseEntity<>(pedidoServicio.PedidoPorCosto(costoNeto),HttpStatus.OK);
    }

    @PostMapping("/agregarPedidos")
    public String agregarPedidos(@RequestBody pedidos Pedidos ){
        return pedidoServicio.agregarPedidos(Pedidos);
    }
}






