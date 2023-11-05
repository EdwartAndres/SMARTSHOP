package com.example.demo.service;

import com.example.demo.Entidad.Venta;
import com.example.demo.repositorio.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> getVentaById(Long idVenta) {
        return ventaRepository.findById(idVenta);
    }

    public Venta createVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Venta updateVenta(Long idVenta, Venta venta) {
        if (ventaRepository.existsById(idVenta)) {
            venta.setIdVenta(Math.toIntExact(idVenta));
            return ventaRepository.save(venta);
        } else {
            return null; // La venta no existe
        }
    }

    public void deleteVenta(Long idVenta) {
        ventaRepository.deleteById(idVenta);
    }
}
