package com.example.demo.service;

import com.example.demo.Entidad.devoluciones;
import com.example.demo.repositorio.DevolucionCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevolucionServicio {
    @Autowired
    private DevolucionCrudRepository devolucionRepository;

    public List<devoluciones> getAllDevoluciones() {
        return devolucionRepository.findAll();
    }

    public Optional<devoluciones> getDevolucionById(Long idDevolucion) {
        return devolucionRepository.findById(idDevolucion);
    }

    public devoluciones createDevolucion(devoluciones devolucion) {
        return devolucionRepository.save(devolucion);
    }

    public devoluciones updateDevolucion(Long idDevolucion, devoluciones devolucion) {
        if (devolucionRepository.existsById(idDevolucion)) {
            devolucion.setIdDevolucion(idDevolucion);
            return devolucionRepository.save(devolucion);
        } else {
            return null; // La devolución no existe
        }
    }
    public void deleteDevolucion(Long idDevolucion) {
        devolucionRepository.deleteById(idDevolucion);
    }
}
