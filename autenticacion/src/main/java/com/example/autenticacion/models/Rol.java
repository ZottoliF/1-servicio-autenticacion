package com.example.autenticacion.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

@Document(collection = "Rol")
public class Rol {
    @Id
   private UUID id;
   private String nombreRol;
   private String descripcion;

   public Rol(UUID id, String nombreRol, String descripcion) {
    this.id = id;
    this.nombreRol = nombreRol;
    this.descripcion = descripcion;   
  }

  // Getters y Setters
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getNombreRol() {
    return nombreRol;
  }

   public void setNombreRol(String nombreRol) {
    this.nombreRol = nombreRol;
  }

  public String getDescripcion() {
    return descripcion;
  }

   public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

}
