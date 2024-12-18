package com.example.autenticacion.services;

import com.example.autenticacion.models.Usuario;
import com.example.autenticacion.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario) {
    
        return usuarioRepository.save(usuario);
    }

    public Usuario autenticarUsuario(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario; // Devuelve el usuario si la autenticación es correcta
        }
        return null; // Devuelve null si la autenticación falla
    }
}
