package com.example.demo.service;

import com.example.demo.Entidad.usuario;
import com.example.demo.repositorio.UsuarioCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioCrudRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioCrudRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public usuario getUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public usuario crearUsuario(usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public usuario actualizarUsuario(Long id, usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
