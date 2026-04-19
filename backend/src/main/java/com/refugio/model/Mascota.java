package com.refugio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "¡El nombre del animal no puede estar vacío!")
    private String nombre;

    @NotBlank(message = "¡Debes especificar la especie!")
    private String especie;

    @Min(value = 0, message = "La edad no puede ser un número negativo")
    private int edad;

    // --- ¡LO NUEVO ESTÁ AQUÍ! ---
    @Min(value = 0, message = "Los meses no pueden ser negativos")
    @Max(value = 11, message = "Los meses deben estar entre 0 y 11")
    private int meses;

    public Mascota() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    // --- NUEVOS GETTERS Y SETTERS PARA MESES ---
    public int getMeses() { return meses; }
    public void setMeses(int meses) { this.meses = meses; }
}