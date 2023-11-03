package com.example.demo.service;
import com.example.demo.Entidad.*;
import com.example.demo.repositorio.PedidoCrudRepository;
import com.example.demo.repositorio.PedidoProductoCrudRepository;
import com.example.demo.repositorio.ProductoCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoProductoServicio {
    private PedidoProductoCrudRepository pedidoProductoCrudRepository;
    private PedidoCrudRepository pedidoCrudRepository;
    private ProductoCrudRepository productoCrudRepository;

    public PedidoProductoServicio(PedidoProductoCrudRepository pedidoProductoCrudRepository, PedidoCrudRepository pedidoCrudRepository, ProductoCrudRepository productoCrudRepository) {
        this.pedidoProductoCrudRepository = pedidoProductoCrudRepository;
        this.pedidoCrudRepository = pedidoCrudRepository;
        this.productoCrudRepository = productoCrudRepository;
    }

    public pedidos_productos pedidosproductosPorCD(Integer cod) {
        if (pedidoProductoCrudRepository.findById(cod).isPresent()) {
            return pedidoProductoCrudRepository.findById(cod).get();
        } else {
            return null;
        }
    }

    public List<pedidos_productos> listarpedidosproductos() {
        return (List<pedidos_productos>) pedidoProductoCrudRepository.findAll();
    }}
    /*public String agregarPedidosProductos(pedidos_productos pedidoProducto ){
        pedidos ped= pedidoCrudRepository.findById(pedidoProducto.getPedidos().getCod_Pedido() ).get();
        productos prds= productoCrudRepository.findById(pedidoProducto.getProductos().getCod_Producto()).get();
        if(productoCrudRepository.findById(pedidoProducto.getProductos().getCod_Producto()).isPresent() && pedidoCrudRepository.findById(pedidoProducto.getPedidos().getCod_Pedido()).isPresent()){
            pedidoProducto.setProductos(prds);
            pedidoProducto.setPedidos(ped);
            pedidoProductoCrudRepository.save(pedidoProducto);
            return "Pedidos_Productos Registrado";
        }
        else return "El Producto y/o Pedido no existen.";
    }

    }*/
