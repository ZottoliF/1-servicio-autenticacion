
package com.example.autenticacion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.autenticacion.models.Permiso;
import com.example.autenticacion.repositories.PermisoRepository;

@Service
public class PermisoService {

    // Inyección del repositorio de Permiso
    @Autowired
    private PermisoRepository permisoRepository;

    // Método para obtener todos los permisos
    public List<Permiso> findAll() {
        // Llama al repositorio para obtener todos los permisos de la base de datos
        return permisoRepository.findAll();
    }

    // Método para obtener un permiso por su ID
    public Optional<Permiso> findById(String id) {
        // Llama al repositorio para encontrar el permiso por ID
        return permisoRepository.findById(id);
    }

    // Método para guardar un permiso
    public Permiso save(Permiso permisoExistente) {
        // Guarda el permiso en la base de datos
        return permisoRepository.save(permisoExistente);
    }

    // Método para eliminar un permiso por su ID (String)
    public void deleteById(String id) {
        // Elimina el permiso por su ID (String)
        permisoRepository.deleteById(id);
    }
}



      
