package com.example.demo.service;
import com.example.demo.Entidad.*;
import com.example.demo.repositorio.ClienteCrudRepository;
import com.example.demo.repositorio.ComprarCrudRepository;
import com.example.demo.repositorio.EmpleadoCrudRepository;
import com.example.demo.repositorio.ProductoCrudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComprarServicio {
    private ComprarCrudRepository comprarCrudRepository;
    private ClienteCrudRepository clienteCrudRepository;
    private EmpleadoCrudRepository empleadoCrudRepository;


    public ComprarServicio(ComprarCrudRepository comprarCrudRepository, ClienteCrudRepository clienteCrudRepository, EmpleadoCrudRepository empleadoCrudRepository) {
        this.comprarCrudRepository = comprarCrudRepository;
        this.clienteCrudRepository = clienteCrudRepository;
        this.empleadoCrudRepository = empleadoCrudRepository;
    }

    public comprar comprarPorCD(Integer cod_Compra) {
        if (comprarCrudRepository.findById(cod_Compra).isPresent()) {
            return comprarCrudRepository.findById(cod_Compra).get();
        } else {
            return null;
        }
    }

    public List<comprar> listarcomprar() {
        return (List<comprar>) comprarCrudRepository.findAll();
    }
    public List<comprar> ComprarPorMetodopago(String metodoPago){
        return comprarCrudRepository.findByMetodoPago(metodoPago);
    }
    public String agregarCompras(comprar Compras ){
        clientes cl= clienteCrudRepository.findById(Compras.getClientes().getCc_clientes() ).get();
        empleados em= empleadoCrudRepository.findById(Compras.getEmpleados().getCc_Empleado()).get();
        if(empleadoCrudRepository.findById(Compras.getEmpleados().getCc_Empleado()).isPresent() && clienteCrudRepository.findById(Compras.getClientes().getCc_clientes()).isPresent()){
            Compras.setEmpleados(em);
            Compras.setClientes(cl);
            Compras.setFecha(LocalDateTime.now());
            comprarCrudRepository.save(Compras);
            return "Compra Registrada";
        }
        else return "El cliente y/o empleado no existen.";
    }
    }
