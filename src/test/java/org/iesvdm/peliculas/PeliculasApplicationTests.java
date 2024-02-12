package org.iesvdm.peliculas;

import org.iesvdm.peliculas.Repository.ActorRepository;
import org.iesvdm.peliculas.Repository.CategoriaRepository;
import org.iesvdm.peliculas.Repository.IdiomaRepository;
import org.iesvdm.peliculas.Repository.PeliculaRepository;
import org.iesvdm.peliculas.domain.Actor;
import org.iesvdm.peliculas.domain.Categoria;
import org.iesvdm.peliculas.domain.Idioma;
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
    IdiomaRepository idiomaRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ActorRepository actorRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void guardarManyToMany() {
        // TODO tests crear pelicula, categoria, actor, idioma
        Pelicula pelicula = new Pelicula(0, "Frozen", "", new HashSet<>(), null, new HashSet<>());
        peliculaRepository.save(pelicula);

        Pelicula pelicula2 = new Pelicula(0, "La Jungla de Cristal", "", new HashSet<>(), null, new HashSet<>());
        peliculaRepository.save(pelicula2);

        Idioma idioma = new Idioma(0L, "Inglés", new HashSet<>());
        idioma.getPeliculas().add(pelicula);
        idiomaRepository.save(idioma);

        Idioma idioma2 = new Idioma(0L, "Español", new HashSet<>());
        idioma2.getPeliculas().add(pelicula2);
        idiomaRepository.save(idioma2);

        pelicula.setIdioma(idioma);
        pelicula2.setIdioma(idioma2);

        peliculaRepository.save(pelicula);
        peliculaRepository.save(pelicula2);

        Categoria categoria = new Categoria(0, "Animación", new HashSet<>());
        categoriaRepository.save(categoria);

        Categoria categoria2 = new Categoria(0, "Terror", new HashSet<>());
        categoriaRepository.save(categoria2);

        Categoria categoria3 = new Categoria(0, "Acción", new HashSet<>());
        categoriaRepository.save(categoria3);

        pelicula.getCategorias().add(categoria);
        categoria.getPeliculas().add(pelicula);

        pelicula.getCategorias().add(categoria2);
        categoria2.getPeliculas().add(pelicula2);

        pelicula2.getCategorias().add(categoria3);
        categoria2.getPeliculas().add(pelicula2);


        peliculaRepository.save(pelicula);
        peliculaRepository.save(pelicula2);

        // Para que este dentro del objeto de Java
        categoriaRepository.save(categoria);
        categoriaRepository.save(categoria2);
        categoriaRepository.save(categoria3);

        Actor actor = new Actor(0L, "Pepe", "Ruiz", new HashSet<>());
        actor.getPeliculas().add(pelicula);
        pelicula.getActores().add(actor);
        actorRepository.save(actor);
        peliculaRepository.save(pelicula);

        Actor actor2 = new Actor(0L, "Paco", "Perez", new HashSet<>());
        actor2.getPeliculas().add(pelicula2);
        pelicula2.getActores().add(actor2);
        actorRepository.save(actor2);
        peliculaRepository.save(pelicula2);
    }
}
