package com.refugio.repository;

import com.refugio.model.Adoptante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptanteRepository extends JpaRepository<Adoptante, Long> {
  // Con esto ya tenemos acceso a la tabla de MariaDB
}
