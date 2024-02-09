package org.iesvdm.peliculas.Repository;

import org.iesvdm.peliculas.domain.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository  extends JpaRepository<Pelicula, Long> {
}
