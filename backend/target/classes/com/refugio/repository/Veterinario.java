package com.refugio.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "veterinarios")
@Data
 interface Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String especialidad;
}