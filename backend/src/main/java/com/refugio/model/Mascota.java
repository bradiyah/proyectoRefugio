package com.refugio.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "mascotas")
@Data 
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String especie;
    private int edad;
    private String estado; // "DISPONIBLE" o "ADOPTADO"
    private String descripcion;
}