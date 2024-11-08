package com.example.autenticacion.services;

<<<<<<< HEAD
public class TokenService {
    
}
=======
import com.example.autenticacion.models.Token;
import com.example.autenticacion.repositories.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public Token crearToken(UUID usuarioId) {
        Token token = new Token(
            UUID.randomUUID().toString(), // Genera nuevo valor de token
            LocalDateTime.now(),
            LocalDateTime.now().plusHours(1), // Expiracion 
            "ACTIVO",
            usuarioId
        );
        return tokenRepository.save(token);
    }

    public Optional<Token> obtenerToken(String token) {
        return tokenRepository.findByToken(token);
    }

    public boolean esTokenValido(String token) {
        Optional<Token> tokenOptional = obtenerToken(token);
        return tokenOptional.isPresent() && 
               tokenOptional.get().getEstadoToken().equals("ACTIVO") &&
               tokenOptional.get().getFechaExpir().isAfter(LocalDateTime.now());
    }

    public void desactivarToken(String token) {
        Optional<Token> tokenOptional = obtenerToken(token);
        tokenOptional.ifPresent(t -> {
            t.setEstadoToken("INACTIVO");
            tokenRepository.save(t);
        });
    }
}
>>>>>>> b70479c78fdd25c5d53a5bc13440ee4cdad3967c
