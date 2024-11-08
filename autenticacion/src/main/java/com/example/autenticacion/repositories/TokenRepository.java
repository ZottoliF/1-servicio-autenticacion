package com.example.autenticacion.repositories;

<<<<<<< HEAD
public class TokenRepository {
    
}
=======
import com.example.autenticacion.models.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends MongoRepository<Token, UUID> {
    Optional<Token> findByToken(String token);
}
>>>>>>> b70479c78fdd25c5d53a5bc13440ee4cdad3967c
