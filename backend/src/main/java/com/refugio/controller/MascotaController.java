package com.refugio.controller;

import com.refugio.model.Mascota;
import com.refugio.repository.MascotaRepository;
import jakarta.validation.Valid; // <-- IMPORTANTE: Esta es la herramienta del portero
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
@CrossOrigin(origins = "*")
public class MascotaController {

    @Autowired
    private MascotaRepository mascotaRepository;

    // 1. Ver todas las mascotas
    @GetMapping
    public List<Mascota> listarMascotas() {
        return mascotaRepository.findAll();
    }

    // 2. Guardar una nueva mascota (CON EL PORTERO @Valid)
    @PostMapping
    public Mascota guardarMascota(@Valid @RequestBody Mascota mascota) {
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

    // 5. Actualizar los datos de una mascota (CON EL PORTERO @Valid)
    @PutMapping("/{id}")
    public Mascota actualizarMascota(@PathVariable Long id, @Valid @RequestBody Mascota mascotaActualizada) {
        // Primero buscamos si la mascota existe
        Mascota mascotaExistente = mascotaRepository.findById(id).orElse(null);

        if (mascotaExistente != null) {
            // Si existe, le actualizamos los datos
            mascotaExistente.setNombre(mascotaActualizada.getNombre());
            mascotaExistente.setEspecie(mascotaActualizada.getEspecie());
            mascotaExistente.setEdad(mascotaActualizada.getEdad());

            mascotaExistente.setMeses(mascotaActualizada.getMeses());

            // Y la volvemos a guardar en la base de datos
            return mascotaRepository.save(mascotaExistente);
        }

        // Si no existe, no devolvemos nada
        return null;
    }
}