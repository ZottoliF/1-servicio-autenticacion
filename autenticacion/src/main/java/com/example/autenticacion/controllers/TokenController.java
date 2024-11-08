package com.example.autenticacion.controllers;

<<<<<<< HEAD
public class TokenController {
    
}
=======
import com.example.autenticacion.models.Token;
import com.example.autenticacion.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/tokens")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/crear")
    public ResponseEntity<Token> crearToken(@RequestParam UUID usuarioId) {
        Token token = tokenService.crearToken(usuarioId);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/validar")
    public ResponseEntity<Boolean> validarToken(@RequestParam String token) {
        boolean esValido = tokenService.esTokenValido(token);
        return ResponseEntity.ok(esValido);
    }

    @PutMapping("/desactivar")
    public ResponseEntity<Void> desactivarToken(@RequestParam String token) {
        tokenService.desactivarToken(token);
        return ResponseEntity.noContent().build();
    }
}
>>>>>>> b70479c78fdd25c5d53a5bc13440ee4cdad3967c
