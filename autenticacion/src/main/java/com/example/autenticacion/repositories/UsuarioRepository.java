package com.example.autenticacion.repositories;

<<<<<<< HEAD
public class UsuarioRepository {
    
=======
import com.example.autenticacion.models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByUsername(String username);
>>>>>>> b70479c78fdd25c5d53a5bc13440ee4cdad3967c
}
