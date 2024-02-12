package org.iesvdm.peliculas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    private String titulo;

    private String descripcion;

//    @Column(name = "anyo_lanzamiento")
//    @JsonFormat(pattern = "yyyy", shape = JsonFormat.Shape.STRING)
//    private Date anyoLanzamiento;
//
//    @Column(name = "duracion_alquiler")
//    private int duracionAlquiler;
//
//    @Column(name = "rental_rate")
//    private BigDecimal rentalRate;
//    private int duracion;
//
//    @Column(name = "replacement_cost")
//    private BigDecimal replacementCost;
//
//    private String clasificacion;
//
//    @Column(name = "caracteristicas_especiales")
//    private String caracteristicasEspeciales;
//
//    @Column(name = "ultima_actualizacion")
//    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss", shape = JsonFormat.Shape.STRING)
//    private Date ultimaActualizacion;
    /**
     * Note that using @JoinTable or even @JoinColumn isn’t required.
     * JPA will generate the table and column names for us.
     * However, the strategy JPA uses won’t always match the naming conventions we use.
     * So, we need the possibility to configure table and column names.
     */
    @ManyToMany
    private Set<Categoria> categorias = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Idioma idioma;

    @ManyToMany(mappedBy = "peliculas") //si no se pone el mapped se crean dos tablas
    private Set<Actor> actores;

}
