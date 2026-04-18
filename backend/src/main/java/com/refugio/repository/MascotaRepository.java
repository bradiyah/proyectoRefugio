package com.refugio.repository;

import com.refugio.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {

    // Esta es la "frase mágica": busca mascotas que NO estén en la tabla de adopciones
    @Query("SELECT m FROM Mascota m WHERE m.id NOT IN (SELECT a.mascota.id FROM Adopcion a)")
    List<Mascota> buscarDisponibles();
}
