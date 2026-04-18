package com.refugio.controller;

import com.refugio.model.Mascota;
import com.refugio.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    @Autowired
    private MascotaRepository mascotaRepository;

    // 1. Ver todas las mascotas
    @GetMapping
    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    // 2. Guardar una nueva mascota
    @PostMapping
    public Mascota guardarMascota(@RequestBody Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    // 3. Buscar una mascota por su ID
    @GetMapping("/{id}")
    public Mascota buscarPorId(@PathVariable Long id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    // 4. Borrar una mascota
    @DeleteMapping("/{id}")
    public void borrarMascota(@PathVariable Long id) {
        mascotaRepository.deleteById(id);
    }

    // Nuevo: Ver solo mascotas que NO han sido adoptadas
    @GetMapping("/disponibles")
    public List<Mascota> listarDisponibles() {
        return mascotaRepository.buscarDisponibles();
    }

}
