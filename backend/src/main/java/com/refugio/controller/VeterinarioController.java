package com.refugio.controller;

import com.refugio.model.Veterinario;
import com.refugio.service.VeterinarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
@CrossOrigin(origins = "*")
public class VeterinarioController {

  @Autowired
  private VeterinarioService veterinarioService;

  @GetMapping
  public List<Veterinario> obtenerVeterinarios() {
    return veterinarioService.obtenerTodos();
  }

  @PostMapping
  public Veterinario guardarVeterinario(@Valid @RequestBody Veterinario veterinario) {
    return veterinarioService.guardar(veterinario);
  }

  @DeleteMapping("/{id}")
  public void borrarVeterinario(@PathVariable Long id) {
    veterinarioService.borrar(id);
  }
}
