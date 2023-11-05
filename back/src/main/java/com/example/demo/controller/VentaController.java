package com.example.demo.controller;
import com.example.demo.Entidad.Venta;
import com.example.demo.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaService.getAllVentas();
    }

    @GetMapping("/{idVenta}")
    public Venta getVentaById(@PathVariable Long idVenta) {
        return ventaService.getVentaById(idVenta).orElse(null);
    }

    @PostMapping
    public Venta createVenta(@RequestBody Venta venta) {
        return ventaService.createVenta(venta);
    }

    @PutMapping("/{idVenta}")
    public Venta updateVenta(@PathVariable Long idVenta, @RequestBody Venta venta) {
        return ventaService.updateVenta(idVenta, venta);
    }

    @DeleteMapping("/{idVenta}")
    public void deleteVenta(@PathVariable Long idVenta) {
        ventaService.deleteVenta(idVenta);
    }
}
