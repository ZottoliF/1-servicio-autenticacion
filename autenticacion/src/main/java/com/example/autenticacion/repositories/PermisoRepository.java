package com.example.autenticacion.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.autenticacion.models.Permiso;
public interface PermisoRepository extends MongoRepository<Permiso, String> {

    // Método para buscar un Permiso por su código
    Permiso findByNombrePermiso(String nombrePermiso);
}
