package com.example.demo.controller;

import com.example.demo.Entidad.detalles;
import com.example.demo.Entidad.pedidos_productos;
import com.example.demo.Entidad.productos;
import com.example.demo.service.PedidoProductoServicio;
import com.example.demo.service.ProductoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class PedidoProductoControlador {
    private PedidoProductoServicio pedidoProductoServicio;

    public PedidoProductoControlador(PedidoProductoServicio pedidoProductoServicio) {
        this.pedidoProductoServicio = pedidoProductoServicio;
    }


    @GetMapping("/listarprodcpds")
    public ResponseEntity<List<pedidos_productos>> listarpedidosproductos() {
        return new ResponseEntity<>(pedidoProductoServicio.listarpedidosproductos(), HttpStatus.OK);

    }

    @GetMapping("/unicoprodcpedido/{cod}")
    public ResponseEntity<pedidos_productos> pedidosproductosPorCD(@PathVariable Integer cod) {
        return new ResponseEntity<>(pedidoProductoServicio.pedidosproductosPorCD(cod), HttpStatus.OK);
    }
        @PostMapping("/agregarPedidosProductos")
        public String agregarPedidosProductos(@RequestBody pedidos_productos pedidoProducto ){
            return pedidoProductoServicio.agregarPedidosProductos(pedidoProducto);
        }


    }





