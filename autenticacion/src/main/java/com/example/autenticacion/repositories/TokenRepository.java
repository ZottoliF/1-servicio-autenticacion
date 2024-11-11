package com.example.autenticacion.repositories;

import com.example.autenticacion.models.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends MongoRepository<Token, UUID> {
    Optional<Token> findByToken(String token);
}
