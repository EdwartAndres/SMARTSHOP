package com.example.demo.controller;
import com.example.demo.Entidad.clientes;
import com.example.demo.Entidad.usuario;
import com.example.demo.service.ClienteServicio;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UsuarioControlador {

    @Autowired
    private UsuarioService userService;

    // Endpoint para obtener todos los usuarios
    @GetMapping
    public List<usuario> getAllUsers() {
        return userService.getAllUsuarios();
    }

    // Endpoint para obtener un usuario por su ID
    @GetMapping("/{userId}")
    public ResponseEntity<usuario> getUserById(@PathVariable Long userId) {
        usuario user = userService.getUsuarioPorId(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<usuario> createUser(@RequestBody usuario user) {
        usuario createdUser = userService.crearUsuario(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // Endpoint para actualizar un usuario existente
    @PutMapping("/{userId}")
    public ResponseEntity<usuario> updateUser(@PathVariable Long userId, @RequestBody usuario user) {
        usuario updatedUser = userService.actualizarUsuario(userId, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.eliminarUsuario(userId);
        return ResponseEntity.noContent().build();
    }
}
