package com.refugio.service;

import com.refugio.model.Mascota;
import com.refugio.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// ¡Esta etiqueta es la clave! Le dice a Spring que este es nuestro "Chef"
@Service
public class MascotaService {

  @Autowired
  private MascotaRepository mascotaRepository;

  // Método para obtener todas las mascotas
  public List<Mascota> obtenerTodasLasMascotas() {
    return mascotaRepository.findAll();
  }

  // Método para guardar una mascota nueva
  public Mascota guardarMascota(Mascota mascota) {
    // Aquí en el futuro podríamos añadir lógica, como comprobar si el nombre ya existe
    return mascotaRepository.save(mascota);
  }

  // Método para borrar
  public void borrarMascota(Long id) {
    mascotaRepository.deleteById(id);
  }

  // Método para actualizar
  public Mascota actualizarMascota(Long id, Mascota mascotaActualizada) {
    Mascota mascotaExistente = mascotaRepository.findById(id).orElse(null);
    if (mascotaExistente != null) {
      mascotaExistente.setNombre(mascotaActualizada.getNombre());
      mascotaExistente.setEspecie(mascotaActualizada.getEspecie());
      mascotaExistente.setEdad(mascotaActualizada.getEdad());
      mascotaExistente.setMeses(mascotaActualizada.getMeses());
      return mascotaRepository.save(mascotaExistente);
    }
    return null;
  }
}
