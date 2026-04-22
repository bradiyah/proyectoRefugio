package com.refugio.service;

import com.refugio.model.SolicitudAdopcion;
import com.refugio.repository.SolicitudAdopcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SolicitudAdopcionService {
  @Autowired
  private SolicitudAdopcionRepository repository;

  public List<SolicitudAdopcion> obtenerTodas() { return repository.findAll(); }
  public SolicitudAdopcion guardar(SolicitudAdopcion solicitud) { return repository.save(solicitud); }
  public void borrar(Long id) { repository.deleteById(id); }
}
