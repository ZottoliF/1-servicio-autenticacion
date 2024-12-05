package com.example.autenticacion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.autenticacion.models.Permiso;

@Service  // Se agrega la anotación @Service
public class PermisoService {

    public List<Permiso> findAll() {
        
        throw new UnsupportedOperationException("metodo no implementado'findAll'");
    }

    public Optional<Permiso> findById(String id) {
       
        throw new UnsupportedOperationException("metodo no implementado 'findById'");
    }

    public Permiso save(Permiso permisoExistente) {
        
        throw new UnsupportedOperationException("metodo no implementado'save'");
    }

    public void deleteById(Long id) {
        
        throw new UnsupportedOperationException("metodo no implementado 'deleteById'");
    }

    public void deleteById(String id) {
        
        throw new UnsupportedOperationException("metodo no implementado 'deleteById'");
    }
    
}
