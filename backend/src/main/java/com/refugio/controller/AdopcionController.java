package com.refugio.controller;

import com.refugio.model.Adopcion;
import com.refugio.repository.AdopcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adopciones")
@CrossOrigin(origins = "*")
public class AdopcionController {

    @Autowired
    private AdopcionRepository adopcionRepository;

    // 1. Ver todas las adopciones realizadas
    @GetMapping
    public List<Adopcion> listarAdopciones() {
        return adopcionRepository.findAll();
    }

    // 2. Registrar una nueva adopción (CON CONTROL ANTI-DUPLICADOS)
    @PostMapping
    public ResponseEntity<?> registrarAdopcion(@RequestBody Adopcion adopcion) {

        // 1. Preguntamos al repositorio: ¿Ya está adoptada esta mascota?
        // (Extraemos el ID de la mascota que viene en la petición)
        Long idMascota = adopcion.getMascota().getId();

        if (adopcionRepository.existsByMascotaId(idMascota)) {
            // 2. Si ya está adoptada, devolvemos un ERROR con un mensaje para el usuario
            return ResponseEntity
                    .badRequest()
                    .body("Lo sentimos, esta mascota ya ha sido adoptada por otra persona.");
        }

        // 3. Si no está adoptada, la guardamos normalmente y devolvemos un OK
        Adopcion nuevaAdopcion = adopcionRepository.save(adopcion);
        return ResponseEntity.ok(nuevaAdopcion);
    }
}
