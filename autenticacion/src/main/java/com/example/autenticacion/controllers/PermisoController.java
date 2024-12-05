package com.example.autenticacion.controllers;




import java.util.List;
import java.util.Optional;  

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
@RequestMapping("/api/Permiso") // Ruta base de la API
//mongodb+srv://servicionaut:gHw4LEnfprNSsjuJ@cluster0.hj9xe.mongodb.net/cluster0?retryWrites=true&w=majority/api/Permiso
//Controlador para manejar las operaciones relacionadas con los permisos
//Metodos HTTP
public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    // Obtener todos los permisos
    //Para hacer esto hay que poner la URL (ruta) de la api en POSTMAN y colocar el metodo GET
    //tambien poner en la url /api/Permiso al final de la URL
    @GetMapping  
    public List<Permiso> obtenerTodosLosPermisos() {
        return permisoService.findAll();
    }

    // Obtener un permiso por ID

    //Para hacer esto hay que poner la URL (ruta) de la api en POSTMAN y colocar el metodo GET
    //tambien poner en la url /api/Permiso/{id}  , (id vendria hacer un String)al final de la URL
    @GetMapping("/{id}")
    public ResponseEntity<Permiso> obtenerPermisoPorId(@PathVariable String id) { 
        Optional<Permiso> permiso = permisoService.findById(id);
        return permiso.isPresent() ? 
            new ResponseEntity<>(permiso.get(), HttpStatus.OK) : 
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Crear un nuevo permiso

    //Para hacer esto hay que poner la URL (ruta) de la api en POSTMAN y colocar el metodo POST
    //tambien poner en la url /api/Permiso al final de la URL
    @PostMapping
    public ResponseEntity<Permiso> crearPermiso(@RequestBody Permiso permiso) {
        Permiso nuevoPermiso = (Permiso) permisoService.save(permiso);
        return new ResponseEntity<>(nuevoPermiso, HttpStatus.CREATED);
    }

    // Actualizar un permiso existente
    //Para hacer esto hay que poner la URL (ruta) de la api en POSTMAN y colocar el metodo PUT
    //tambien poner en la url /api/Permiso/{id}  , (id vendria hacer un String)al final de la URL
    @PutMapping("/{id}")
    public ResponseEntity<Permiso> actualizarPermiso(@PathVariable String id, @RequestBody Permiso permisoDetalles) { 
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
    //Para hacer esto hay que poner la URL (ruta) de la api en POSTMAN y colocar el metodo DELETE
    //tambien poner en la url /api/Permiso/{id}  , (id vendria hacer un String)al final de la URL
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPermiso(@PathVariable String id) { 
        Optional<Permiso> permiso = permisoService.findById(id);
        if (permiso.isPresent()) {
            permisoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


