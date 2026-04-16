package com.refugio.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "adopciones")
@Data
public class Adopcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Muchas adopciones pueden referirse a una mascota
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    @ManyToOne // Un usuario puede hacer muchas adopciones
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private LocalDate fechaAdopcion;
}