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
        return rolRepository.findById(id).orElse(null);
    }

    public Rol guardarRol(Rol rol) {
        return RolRepository.save(rol);
    }

    public Rol actualizarRol(UUID id, Rol RolActualizado) {
        return rolRepository.findById(id)
                .map(rol -> {
                    rol.setNombreRol(rolActualizado.getNombreRol());
                    rol.setDescripcion(rolActualizado.getDescripcion());
                    return RolRepository.save(Rol);
                })
                .orElse(null);
    }

    public void eliminarRol(Long id) {
        rolRepository.deleteById(id);
    }
}
