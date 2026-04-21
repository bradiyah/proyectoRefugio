package com.refugio.service;

import com.refugio.model.Veterinario;
import com.refugio.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioService {

  @Autowired
  private VeterinarioRepository veterinarioRepository;

  public List<Veterinario> obtenerTodos() {
    return veterinarioRepository.findAll();
  }

  public Veterinario guardar(Veterinario veterinario) {
    return veterinarioRepository.save(veterinario);
  }

  public void borrar(Long id) {
    veterinarioRepository.deleteById(id);
  }
}
