package com.example.autenticacion.services;

import com.example.autenticacion.models.Rol;
import com.example.autenticacion.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;

@Service
public class RolService {
    @Autowired
    private RolRepository RolRepository;

    public List<Rol> obtenerTodosLosRol() {
        return RolRepository.findAll();
    }

    public Rol obtenerRolPorId (UUID id) {
        return RolRepository.findById(id).orElse(null);
    }

    public Rol guardarRol(Rol rol) {
        return RolRepository.save(rol);
    }

    public Rol actualizarRol(UUID id, Rol RolActualizado) {
        return RolRepository.findById(id)
                .map(rol -> {
                    rol.setNombreRol(RolActualizado.getNombreRol());
                    rol.setDescripcion(RolActualizado.getDescripcion());
                    return RolRepository.save(rol);
                })
                .orElse(null);
    }

    public void eliminarRol(UUID id) {
        RolRepository.deleteById(id);
    }
}
