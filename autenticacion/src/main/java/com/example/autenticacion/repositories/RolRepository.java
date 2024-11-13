package com.example.autenticacion.repositories;

import com.example.autenticacion.models.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
import java.util.UUID;

public interface RolRepository  extends MongoRepository<Rol, UUID> {
    Optional<Rol> findByNombreRol(String nombreRol);
}
