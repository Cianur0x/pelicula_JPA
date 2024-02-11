package org.iesvdm.peliculas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_idioma")
    private Long id;

    private String nombre;

    @Column(name = "ultima_actualizacion")
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date ultimaActualizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "id_idioma_original")
    private Pelicula pelicula;

    // Agrega la columna clave foránea
    @Column(name = "id_idioma_original")
    private Long id_idioma_original;
}
