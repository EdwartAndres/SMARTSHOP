package com.example.demo.controller;

import com.example.demo.Entidad.pedidos;
import com.example.demo.Entidad.pedidos_productos;
import com.example.demo.Entidad.productos;
import com.example.demo.service.PedidoServicio;
import com.example.demo.service.ProductoServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class ProductoControlador {
    private ProductoServicio productoServicio;

    public ProductoControlador(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }


    @GetMapping("/listarprodc")
    public ResponseEntity<List<productos>>listarpedidos(){
        return new ResponseEntity<>(productoServicio.listarproductos(), HttpStatus.OK);

    }
    @GetMapping("/unicoprodc/{cod_Producto}")
    public ResponseEntity<productos>pedidosPorCD(@PathVariable Integer cod_Producto){
        return new ResponseEntity<>(productoServicio.productosPorCD(cod_Producto),HttpStatus.OK);
        }

    @GetMapping("/unicoprcts/{nomProducto}")
    public  ResponseEntity <List<productos>> ProductoPorNombre(@PathVariable ("nomProducto") String nomProducto){
        return  new ResponseEntity<>(productoServicio.ProductoPorNombre(nomProducto),HttpStatus.OK);
    }
    @PostMapping("/agregarProductos")
    public String agregarProductos(@RequestBody productos Productos ){
        return productoServicio.agregarProductos(Productos);
    }

}






