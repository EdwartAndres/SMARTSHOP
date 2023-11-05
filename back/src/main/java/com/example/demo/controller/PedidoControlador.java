package com.example.demo.controller;
import com.example.demo.Entidad.Pedido;
import com.example.demo.service.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoControlador {
    @Autowired
    private PedidoServicio pedidoService;

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/{idPedido}")
    public Pedido getPedidoById(@PathVariable Long idPedido) {
        return pedidoService.getPedidoById(idPedido).orElse(null);
    }

    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoService.createPedido(pedido);
    }

    @PutMapping("/{idPedido}")
    public Pedido updatePedido(@PathVariable Long idPedido, @RequestBody Pedido pedido) {
        return pedidoService.updatePedido(idPedido, pedido);
    }

    @DeleteMapping("/{idPedido}")
    public void deletePedido(@PathVariable Long idPedido) {
        pedidoService.deletePedido(idPedido);
    }
}





