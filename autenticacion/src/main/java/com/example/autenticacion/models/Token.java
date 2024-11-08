package com.example.autenticacion.models;

<<<<<<< HEAD
public class Token {
    
=======
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "tokens")
public class Token {

    @Id
    private UUID id;
    private String token;
    private LocalDateTime fechaCreac;
    private LocalDateTime fechaExpir;
    private String estadoToken;

    
    private UUID usuarioId; 

    public Token() {
    }

    public Token(String token, LocalDateTime fechaCreac, LocalDateTime fechaExpir, String estadoToken, UUID usuarioId) {
        this.id = UUID.randomUUID();
        this.token = token;
        this.fechaCreac = fechaCreac;
        this.fechaExpir = fechaExpir;
        this.estadoToken = estadoToken;
        this.usuarioId = usuarioId;
    }

    // Getters y Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getFechaCreac() {
        return fechaCreac;
    }

    public void setFechaCreac(LocalDateTime fechaCreac) {
        this.fechaCreac = fechaCreac;
    }

    public LocalDateTime getFechaExpir() {
        return fechaExpir;
    }

    public void setFechaExpir(LocalDateTime fechaExpir) {
        this.fechaExpir = fechaExpir;
    }

    public String getEstadoToken() {
        return estadoToken;
    }

    public void setEstadoToken(String estadoToken) {
        this.estadoToken = estadoToken;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }
>>>>>>> b70479c78fdd25c5d53a5bc13440ee4cdad3967c
}
