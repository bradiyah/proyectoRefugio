package com.refugio.controller;

import com.refugio.model.Adopcion;
import com.refugio.repository.AdopcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adopciones")
public class AdopcionController {

    @Autowired
    private AdopcionRepository adopcionRepository;

    // 1. Ver todas las adopciones realizadas
    @GetMapping
    public List<Adopcion> listarAdopciones() {
        return adopcionRepository.findAll();
    }

    // 2. Registrar una nueva adopción
    @PostMapping
    public Adopcion registrarAdopcion(@RequestBody Adopcion adopcion) {
        return adopcionRepository.save(adopcion);
    }
}
