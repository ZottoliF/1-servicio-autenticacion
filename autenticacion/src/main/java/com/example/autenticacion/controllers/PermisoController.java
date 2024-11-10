package com.example.autenticacion.controllers;




import java.util.List;
import java.util.Optional;  // Se agrega la importación de Optional

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.autenticacion.models.Permiso;
import com.example.autenticacion.services.PermisoService;

@RestController
@RequestMapping("/api/Permiso")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    // Obtener todos los permisos
    @GetMapping
    public List<Permiso> obtenerTodosLosPermisos() {
        return permisoService.findAll();
    }

    // Obtener un permiso por ID
    @GetMapping("/{id}")
    public ResponseEntity<Permiso> obtenerPermisoPorId(@PathVariable Long id) { // Ajusté a Long, si tu ID es diferente, cámbialo
        Optional<Permiso> permiso = permisoService.findById(id);
        return permiso.isPresent() ? 
            new ResponseEntity<>(permiso.get(), HttpStatus.OK) : 
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Crear un nuevo permiso
    @PostMapping
    public ResponseEntity<Permiso> crearPermiso(@RequestBody Permiso permiso) {
        Permiso nuevoPermiso = (Permiso) permisoService.save(permiso);
        return new ResponseEntity<>(nuevoPermiso, HttpStatus.CREATED);
    }

    // Actualizar un permiso existente
    @PutMapping("/{id}")
    public ResponseEntity<Permiso> actualizarPermiso(@PathVariable Long id, @RequestBody Permiso permisoDetalles) { // Ajusté a Long también aquí
        Optional<Permiso> permisoOptional = permisoService.findById(id);
        if (permisoOptional.isPresent()) {
            Permiso permisoExistente = permisoOptional.get();
            permisoExistente.setNombrePermiso(permisoDetalles.getNombrePermiso());
            permisoExistente.setDescripcion(permisoDetalles.getDescripcion());
            permisoService.save(permisoExistente);
            return new ResponseEntity<>(permisoExistente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un permiso por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPermiso(@PathVariable Long id) { // Ajusté a Long aquí también
        Optional<Permiso> permiso = permisoService.findById(id);
        if (permiso.isPresent()) {
            permisoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


