package com.example.autenticacion.controllers;

import com.example.autenticacion.models.Rol;
import com.example.autenticacion.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/api/Rol")
public class RolController {
    @Autowired
    private RolService RolService;

    @GetMapping
    public List<Rol> obtenerTodosLosRol() {
        return RolService.obtenerTodosLosRol();
    }

    @GetMapping("/{id}")
    public Rol obtenerRolPorId(@PathVariable UUID id) {
        return RolService.obtenerRolPorId(id);
    }

    @PostMapping
    public Rol crearRol(@RequestBody Rol rol) {
        return RolService.guardarRol(rol);
    }

    @PutMapping("/{id}")
    public Rol actualizarRol(@PathVariable UUID id, @RequestBody Rol rol) {
        return RolService.actualizarRol(id, rol);
    }

    @DeleteMapping("/{id}")
    public void eliminarRol(@PathVariable UUID id) {
        RolService.eliminarRol(id);
    }
}