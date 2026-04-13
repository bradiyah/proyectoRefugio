package com.refugio.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "veterinarios")
@Data
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String especialidad;
}