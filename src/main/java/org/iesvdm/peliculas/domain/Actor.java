package org.iesvdm.peliculas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Date;
import java.util.Set;

@Entity
public class Actor {
    @Id
    private Long id;
    private String nombre;

    private String apellidos;

    @Column(name = "ultima_actualizacion")
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date ultimaActualizacion;

    @ManyToMany
    private Set<Pelicula> peliculas;
}
