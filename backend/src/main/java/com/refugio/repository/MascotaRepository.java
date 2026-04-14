package com.refugio.repository;

import com.refugio.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    // Aquí ya tenemos: save(), findAll(), deleteById(), etc.
}
