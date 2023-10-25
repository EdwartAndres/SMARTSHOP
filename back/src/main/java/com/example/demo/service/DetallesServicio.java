package com.example.demo.service;
import com.example.demo.Entidad.comprar;
import com.example.demo.Entidad.detalles;
import com.example.demo.Entidad.productos;
import com.example.demo.repositorio.ComprarCrudRepository;
import com.example.demo.repositorio.DetallesCrudRepository;
import com.example.demo.repositorio.ProductoCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallesServicio {
    private DetallesCrudRepository detallesCrudRepository;
    private ProductoCrudRepository productoCrudRepository;
    private ComprarCrudRepository comprarCrudRepository;


    public DetallesServicio(DetallesCrudRepository detallesCrudRepository, ProductoCrudRepository productoCrudRepository, ComprarCrudRepository comprarCrudRepository) {
        this.detallesCrudRepository = detallesCrudRepository;
        this.productoCrudRepository = productoCrudRepository;
        this.comprarCrudRepository = comprarCrudRepository;
    }

    public detalles detallesPorCD(Integer cod_Identificacion) {
        if (detallesCrudRepository.findById(cod_Identificacion).isPresent()) {
            return detallesCrudRepository.findById(cod_Identificacion).get();
        } else {
            return null;
        }
    }
    public String agregarDetalles(detalles detalle ){
        productos pdr= productoCrudRepository.findById(detalle.getProductos().getCod_Producto()).get();
        comprar com= comprarCrudRepository.findById(detalle.getComprar().getCod_Compra()).get();
        if(productoCrudRepository.findById(detalle.getProductos().getCod_Producto()).isPresent() && comprarCrudRepository.findById(detalle.getComprar().getCod_Compra()).isPresent()){
            detalle.setProductos(pdr);
            detalle.setComprar(com);
            detallesCrudRepository.save(detalle);
            return "Detalle Registrado";
        }
        else return "El Producto y/o Compra no existen.";
    }
    public List<detalles> listardetalles() {
        return (List<detalles>) detallesCrudRepository.findAll();
    }
    public List<detalles> DetallesPorPrecio(int precio){
        return detallesCrudRepository.findByPrecio(precio);
    }

    }
