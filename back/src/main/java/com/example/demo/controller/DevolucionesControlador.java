package com.example.demo.controller;
import com.example.demo.Entidad.devoluciones;
import com.example.demo.service.DevolucionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/devoluciones")
public class DevolucionesControlador {
    @Autowired
    private DevolucionServicio devolucionService;

    @GetMapping
    public List<devoluciones> getAllDevoluciones() {
        return devolucionService.getAllDevoluciones();
    }

    @GetMapping("/{idDevolucion}")
    public devoluciones getDevolucionById(@PathVariable Long idDevolucion) {
        return devolucionService.getDevolucionById(idDevolucion).orElse(null);
    }

    @PostMapping
    public devoluciones createDevolucion(@RequestBody devoluciones devolucion) {
        return devolucionService.createDevolucion(devolucion);
    }

    @PutMapping("/{idDevolucion}")
    public devoluciones updateDevolucion(@PathVariable Long idDevolucion, @RequestBody devoluciones devolucion) {
        return devolucionService.updateDevolucion(idDevolucion, devolucion);
    }

    @DeleteMapping("/{idDevolucion}")
    public void deleteDevolucion(@PathVariable Long idDevolucion) {
        devolucionService.deleteDevolucion(idDevolucion);
    }
}
