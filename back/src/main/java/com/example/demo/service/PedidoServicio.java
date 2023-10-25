package com.example.demo.service;
import com.example.demo.Entidad.*;
import com.example.demo.repositorio.DistribuidorCrudRepository;
import com.example.demo.repositorio.EmpleadoCrudRepository;
import com.example.demo.repositorio.PedidoCrudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoServicio {
    private PedidoCrudRepository pedidoCrudRepository;
    private DistribuidorCrudRepository distribuidorCrudRepository;

    public PedidoServicio(PedidoCrudRepository pedidoCrudRepository, DistribuidorCrudRepository distribuidorCrudRepository) {
        this.pedidoCrudRepository = pedidoCrudRepository;
        this.distribuidorCrudRepository = distribuidorCrudRepository;
    }

    public pedidos pedidosPorCD(Integer cod_Pedido) {
        if (pedidoCrudRepository.findById(cod_Pedido).isPresent()) {
            return pedidoCrudRepository.findById(cod_Pedido).get();
        } else {
            return null;
        }
    }

    public String agregarPedidos(pedidos Pedidos ){
        distribuidores dst= distribuidorCrudRepository.findById(Pedidos.getDistribuidoresA().getNitDistribuidor()).get();
        if(distribuidorCrudRepository.findById(Pedidos.getDistribuidoresA().getNitDistribuidor()).isPresent() ){
            Pedidos.setDistribuidoresA(dst);
            Pedidos.setFechapedido(LocalDateTime.now());
            pedidoCrudRepository.save(Pedidos);
            return "Pedido Registrado";
        }
        else return "El distribuidor  no existen.";
    }
    public List<pedidos> listarpedidos() {
        return (List<pedidos>) pedidoCrudRepository.findAll();
    }
    public List<pedidos> PedidoPorCosto(int costoNeto){
        return pedidoCrudRepository.findByCostoNeto(costoNeto);
    }

    }
