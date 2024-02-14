package org.iesvdm.peliculas;

import jakarta.transaction.Transactional;
import org.iesvdm.peliculas.Repository.ActorRepository;
import org.iesvdm.peliculas.Repository.CategoriaRepository;
import org.iesvdm.peliculas.Repository.IdiomaRepository;
import org.iesvdm.peliculas.Repository.PeliculaRepository;
import org.iesvdm.peliculas.domain.Actor;
import org.iesvdm.peliculas.domain.Categoria;
import org.iesvdm.peliculas.domain.Idioma;
import org.iesvdm.peliculas.domain.Pelicula;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.HashSet;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PeliculasApplicationTests {
    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    IdiomaRepository idiomaRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    private PlatformTransactionManager transactionManager;
    private TransactionTemplate transactionTemplate;

    @BeforeEach
    public void setUp() {
        transactionTemplate = new TransactionTemplate(transactionManager);
    }

    @Test
    void contextLoads() {
    }

    @Test
    @Order(1)
    void cargarDatos() {
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

        Categoria categoria = new Categoria(0L, "Animación", new HashSet<>());
        categoriaRepository.save(categoria);

        Categoria categoria2 = new Categoria(0L, "Acción", new HashSet<>());
        categoriaRepository.save(categoria2);

        pelicula.getCategorias().add(categoria);
        categoria.getPeliculas().add(pelicula);

        pelicula2.getCategorias().add(categoria2);
        categoria2.getPeliculas().add(pelicula2);

        peliculaRepository.save(pelicula);
        peliculaRepository.save(pelicula2);

        // Para que este dentro del objeto de Java

        Actor actor = new Actor(0L, "Pepe", "Ruiz", new HashSet<>());
        actor.getPeliculas().add(pelicula);
        pelicula.getActores().add(actor);
        actorRepository.save(actor);

        Actor actor2 = new Actor(0L, "Paco", "Perez", new HashSet<>());
        actor2.getPeliculas().add(pelicula2);
        pelicula2.getActores().add(actor2);
        actorRepository.save(actor2);
    }

    @Test
    @Order(2)
    void getPeliculas() {
        transactionTemplate.execute(status -> {
            var peliculas = peliculaRepository.findAll();
            peliculas.forEach(peli -> System.out.println("Hola " + peli));
            return null;
        });
    }

    @Test
    @Order(3)
    void getCategorias() {
        transactionTemplate.execute(status -> {
            var categorias = categoriaRepository.findAll();
            categorias.forEach(System.out::println);
            return null;
        });
    }

    @Test
    @Order(4)
    void getIdiomas() {
        transactionTemplate.execute(status -> {
            var idiomaList = idiomaRepository.findAll();
            idiomaList.forEach(System.out::println);
            return null;
        });
    }

    @Test
    @Order(5)
    void getActores() {
        transactionTemplate.execute(status -> {
            var actorList = actorRepository.findAll();
            actorList.forEach(System.out::println);
            return null;
        });
    }
}
