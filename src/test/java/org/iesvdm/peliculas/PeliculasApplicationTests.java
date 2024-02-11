package org.iesvdm.peliculas;

import org.iesvdm.peliculas.Repository.CategoriaRepository;
import org.iesvdm.peliculas.Repository.PeliculaRepository;
import org.iesvdm.peliculas.domain.Categoria;
import org.iesvdm.peliculas.domain.Pelicula;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
class PeliculasApplicationTests {
    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void guardarManyToMany() {
//        Pelicula pelicula = new Pelicula(0, "Frozen", new HashSet<>());
//        peliculaRepository.save(pelicula);
//
//        Categoria categoria = new Categoria(0, "Animacion", new HashSet<>());
//        categoriaRepository.save(categoria);
//
//        Categoria categoria2 = new Categoria(0, "Terror", new HashSet<>());
//        categoriaRepository.save(categoria2);
//
//        pelicula.getCategorias().add(categoria);
//        // categoria.getPeliculas().add(pelicula);
//        pelicula.getCategorias().add(categoria2);
//        // categoria2.getPeliculas().add(pelicula);
//        peliculaRepository.save(pelicula);
//        // TODO IDIOMA, one to many
//        // TODO ACTOR, many to many
//        // Para que este dentro del objeto de Java
//        categoriaRepository.save(categoria2);
//        categoriaRepository.save(categoria);
    }
}
