package com.example.demo.service;
import com.example.demo.Entidad.clientes;
import com.example.demo.repositorio.ClienteCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServicio {
    private ClienteCrudRepository clienteCrudRepository;
    public ClienteServicio(ClienteCrudRepository clienteCrudRepository) {
        this.clienteCrudRepository = clienteCrudRepository;
    }
    public clientes insertarclientes(clientes Clientes) {
        return clienteCrudRepository.save(Clientes);
    }
    public clientes clientesPorCC(Integer cc_clientes) {
        if (clienteCrudRepository.findById(cc_clientes).isPresent()) {
            return clienteCrudRepository.findById(cc_clientes).get();
        } else {
            return null;
        }
    }
    public List<clientes> listaClientes() {
        return (List<clientes>) clienteCrudRepository.findAll();
    }
    public void eliminarClientes (Integer id){
        clienteCrudRepository.deleteById(id);
    }
    public void actualizarClientes (clientes Clientes){
        clienteCrudRepository.actualizarClientes(Clientes.getNomCliente(), Clientes.getCc_clientes());
    }
    public List<clientes> findByNomCliente(String nomCliente) {
        return clienteCrudRepository.findByNomCliente(nomCliente);
    }
  }
