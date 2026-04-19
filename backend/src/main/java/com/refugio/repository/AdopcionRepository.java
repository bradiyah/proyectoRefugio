package com.refugio.repository;

import com.refugio.model.Adopcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdopcionRepository extends JpaRepository<Adopcion, Long> {

    // Esta línea le pide a Spring que mire si existe alguna adopción con el ID de esa mascota
    boolean existsByMascotaId(Long mascotaId);


}
