package org.iesvdm.peliculas.Repository;

import org.iesvdm.peliculas.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
