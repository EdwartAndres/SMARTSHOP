package com.example.demo.service;

import com.example.demo.Entidad.Venta;
import com.example.demo.repositorio.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VentaService {
    private final VentaRepository ventaRepository;

    @Autowired
    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> getVentaById(Integer idVenta) {
        return ventaRepository.findById(Long.valueOf(idVenta));
    }

    public Venta createVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Venta updateVenta(Integer idVenta, Venta venta) {

        return venta;
    }

    public void deleteVenta(Integer idVenta) {
        ventaRepository.deleteById(Long.valueOf(idVenta));
    }
}
