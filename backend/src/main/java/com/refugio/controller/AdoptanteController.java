package com.refugio.controller;

import com.refugio.model.Adoptante;
import com.refugio.service.AdoptanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adoptantes")
@CrossOrigin(origins = "*")
public class AdoptanteController {

  @Autowired
  private AdoptanteService adoptanteService;

  @GetMapping
  public List<Adoptante> obtenerAdoptantes() {
    return adoptanteService.obtenerTodos();
  }

  @PostMapping
  public Adoptante guardarAdoptante(@Valid @RequestBody Adoptante adoptante) {
    return adoptanteService.guardar(adoptante);
  }

  @PutMapping("/{id}")
  public Adoptante actualizarAdoptante(@PathVariable Long id, @Valid @RequestBody Adoptante adoptante) {
    return adoptanteService.actualizar(id, adoptante);
  }

  @DeleteMapping("/{id}")
  public void borrarAdoptante(@PathVariable Long id) {
    adoptanteService.borrar(id);
  }
}
