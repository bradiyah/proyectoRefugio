package com.refugio.controller;

import com.refugio.model.Mascota;
import com.refugio.service.MascotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
@CrossOrigin(origins = "*")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public List<Mascota> obtenerMascotas() {
        return mascotaService.obtenerTodasLasMascotas();
    }

    @PostMapping
    public Mascota guardarMascota(@Valid @RequestBody Mascota mascota) {
        return mascotaService.guardarMascota(mascota);
    }

    @PutMapping("/{id}")
    public Mascota actualizarMascota(@PathVariable Long id, @Valid @RequestBody Mascota mascota) {
        return mascotaService.actualizarMascota(id, mascota);
    }

    @DeleteMapping("/{id}")
    public void borrarMascota(@PathVariable Long id) {
        mascotaService.borrarMascota(id);
    }
}