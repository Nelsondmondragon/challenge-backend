package com.nedacort.challengespringbackend.persistence.crud;

import com.nedacort.challengespringbackend.persistence.entity.Pelicula;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class PeliculaCrudRepositoryTest {


    private static Pelicula pelicula;
    private static Pelicula pelicula1;
    @Autowired
    private PeliculaCrudRepository peliculaCrudRepository;

    @BeforeAll
    static void initAll() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.US);
        pelicula = Pelicula.builder()
                .id(2)
                .titulo("It")
                .fechaCreacion(LocalDate.parse("10/08/2008", dateTimeFormatter).atStartOfDay())
                .idGenero(1)
                .idCalificacion(4)
                .build();
        pelicula1 = Pelicula.builder()
                .id(1)
                .titulo("Conjuro")
                .fechaCreacion(LocalDate.parse("10/08/2009", dateTimeFormatter).atStartOfDay())
                .idGenero(1)
                .idCalificacion(3)
                .build();
    }

    @Test
    void get_all_movies_that_contain_the_string() {
        assertThat(peliculaCrudRepository.findByName("Con").isPresent()).isTrue();
    }

    @Test
    void get_all_movies_that_contain_the_genre() {
        assertThat(peliculaCrudRepository.findByIdGenero(1).isPresent()).isTrue();
    }


    @Test
    void get_all_movies_by_creation_date_sorted_asc() {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(pelicula);
        peliculas.add(pelicula1);
        assertThat(peliculaCrudRepository.findAllByFechaCreacionAsc().get())
                .usingRecursiveComparison()
                .ignoringFields("genero", "calificacion", "personajePeliculas")
                .isEqualTo(peliculas);
    }


    @Test
    void get_all_movies_by_creation_date_sorted_desc() {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(pelicula1);
        peliculas.add(pelicula);
        assertThat(peliculaCrudRepository.findAllByFechaCreacionDesc().get())
                .usingRecursiveComparison()
                .ignoringFields("genero", "calificacion", "personajePeliculas")
                .isEqualTo(peliculas);
    }


}