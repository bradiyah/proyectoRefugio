package com.refugio.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "adopciones")
public class Adopcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Mascota mascota;

    @ManyToOne
    private Usuario usuario;

    private LocalDate fechaAdopcion;

    public Adopcion() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Mascota getMascota() { return mascota; }
    public void setMascota(Mascota mascota) { this.mascota = mascota; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public LocalDate getFechaAdopcion() { return fechaAdopcion; }
    public void setFechaAdopcion(LocalDate fechaAdopcion) { this.fechaAdopcion = fechaAdopcion; }
}
