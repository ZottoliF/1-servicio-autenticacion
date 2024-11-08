package com.example.autenticacion.controllers;

<<<<<<< HEAD
public class UsuarioController {
    
=======
import com.example.autenticacion.models.Usuario;
import com.example.autenticacion.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    @PostMapping("/login")
    public Usuario autenticarUsuario(@RequestParam String username, @RequestParam String password) {
        return usuarioService.autenticarUsuario(username, password);
    }
>>>>>>> b70479c78fdd25c5d53a5bc13440ee4cdad3967c
}
