package com.refugio.service;

import com.refugio.model.Adoptante;
import com.refugio.repository.AdoptanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptanteService {

  @Autowired
  private AdoptanteRepository adoptanteRepository;

  public List<Adoptante> obtenerTodos() {
    return adoptanteRepository.findAll();
  }

  public Adoptante guardar(Adoptante adoptante) {
    return adoptanteRepository.save(adoptante);
  }

  public void borrar(Long id) {
    adoptanteRepository.deleteById(id);
  }

  public Adoptante actualizar(Long id, Adoptante datosNuevos) {
    Adoptante existente = adoptanteRepository.findById(id).orElse(null);
    if (existente != null) {
      existente.setNombre(datosNuevos.getNombre());
      existente.setTelefono(datosNuevos.getTelefono());
      existente.setDireccion(datosNuevos.getDireccion());
      return adoptanteRepository.save(existente);
    }
    return null;
  }
}
