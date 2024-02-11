package org.iesvdm.peliculas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    /**
     * On the target side, we only have to provide the name of the field,
     * which maps the relationship.
     */

    @ManyToMany(mappedBy = "categorias")
    Set<Pelicula> peliculas = new HashSet<>();

}
