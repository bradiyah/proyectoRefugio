package com.refugio.controller;

import com.refugio.model.SolicitudAdopcion;
import com.refugio.service.SolicitudAdopcionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
@CrossOrigin(origins = "*")
public class SolicitudAdopcionController {

  @Autowired
  private SolicitudAdopcionService service;

  @GetMapping
  public List<SolicitudAdopcion> obtenerSolicitudes() { return service.obtenerTodas(); }

  @PostMapping
  public SolicitudAdopcion guardarSolicitud(@Valid @RequestBody SolicitudAdopcion solicitud) { return service.guardar(solicitud); }

  @DeleteMapping("/{id}")
  public void borrarSolicitud(@PathVariable Long id) { service.borrar(id); }
}
