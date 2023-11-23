package com.example.demo.controller;
import com.example.demo.Entidad.clientes;
import com.example.demo.service.ClienteServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin (origins = "*", allowedHeaders = "*")

public class ClienteControlador {
    private ClienteServicio clienteServicio;

    public ClienteControlador(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @PostMapping("/insertar")
    public ResponseEntity<Void>insertarclientes(@RequestBody clientes Clientes){
        if (clienteServicio.clientesPorCC(Clientes.getCc_clientes())!=null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } else {
            clienteServicio.insertarclientes(Clientes);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @GetMapping("/listar")
    public ResponseEntity<List<clientes>>listarClientes(){

        return new ResponseEntity<>(clienteServicio.listaClientes(), HttpStatus.OK);

    }
    @GetMapping("/unico/{cc_clientes}")
    public ResponseEntity<clientes>clientesPorCC(@PathVariable Integer cc_clientes){
        return new ResponseEntity<>(clienteServicio.clientesPorCC(cc_clientes),HttpStatus.OK);
        }

    @DeleteMapping("/eliminar/{cc_clientes}")
    public ResponseEntity<Void> eliminarClientes(@PathVariable Integer cc_clientes){
        if(clienteServicio.clientesPorCC(cc_clientes)!=null){
            clienteServicio.eliminarClientes(cc_clientes);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/actualizar")
    public ResponseEntity<Void> actualizarClientes(@RequestBody clientes Clientes){
        if(clienteServicio.clientesPorCC(Clientes.getCc_clientes())!=null){
            clienteServicio.actualizarClientes(Clientes);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/api/clientes/{clienteInput}")
    public ResponseEntity<String> clientesPorNombreOCedula(@PathVariable String clienteInput) {
        List<clientes> clientesEncontrados = clienteServicio.findByNomCliente(clienteInput);

        if (!clientesEncontrados.isEmpty()) {
            return new ResponseEntity<>(clientesEncontrados.get(0).getNomCliente(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/actualizarSave")
    public ResponseEntity<Void> actualizarClientesSave(@RequestBody clientes Clientes){
        if(clienteServicio.clientesPorCC(Clientes.getCc_clientes())!=null){
            clienteServicio.insertarclientes(Clientes);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}





