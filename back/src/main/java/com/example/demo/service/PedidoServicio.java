package com.example.demo.service;
import com.example.demo.Entidad.Pedido;
import com.example.demo.repositorio.PedidoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio {
    @Autowired
    private PedidoCrudRepository pedidoRepository;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> getPedidoById(Long idPedido) {
        return pedidoRepository.findById(idPedido);
    }

    public Pedido createPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido updatePedido(Long idPedido, Pedido pedido) {
        if (pedidoRepository.existsById(idPedido)) {
            pedido.setIdPedido(idPedido);
            return pedidoRepository.save(pedido);
        } else {
            return null; // El pedido no existe
        }
    }

    public void deletePedido(Long idPedido) {
        pedidoRepository.deleteById(idPedido);
    }
}
