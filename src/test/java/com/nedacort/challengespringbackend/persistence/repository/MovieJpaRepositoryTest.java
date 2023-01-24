package com.nedacort.challengespringbackend.persistence.repository;

import com.nedacort.challengespringbackend.persistense.entities.Movie;
import com.nedacort.challengespringbackend.persistense.repositoryjpa.MovieJpaRepository;
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
class MovieJpaRepositoryTest {

//
//    private static Movie movie;
//    private static Movie movie1;
//    @Autowired
//    private MovieJpaRepository peliculaCrudRepository;
//
//    @BeforeAll
//    static void initAll() {
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.US);
//        movie = Movie.builder()
//                .idMovie(2)
//                .title("It")
//                .fechaCreacion(LocalDate.parse("10/08/2008", dateTimeFormatter).atStartOfDay())
//                .idGenero(1)
//                .idCalificacion(4)
//                .build();
//        movie1 = Movie.builder()
//                .idMovie(1)
//                .title("Conjuro")
//                .fechaCreacion(LocalDate.parse("10/08/2009", dateTimeFormatter).atStartOfDay())
//                .idGenero(1)
//                .idCalificacion(3)
//                .build();
//    }
//
//    @Test
//    void get_all_movies_that_contain_the_string() {
//        assertThat(peliculaCrudRepository.findByName("Con").isPresent()).isTrue();
//    }
//
//    @Test
//    void get_all_movies_that_contain_the_genre() {
//        assertThat(peliculaCrudRepository.findByIdGenero(1).isPresent()).isTrue();
//    }
//
//
//    @Test
//    void get_all_movies_by_creation_date_sorted_asc() {
//        List<Movie> movies = new ArrayList<>();
//        movies.add(movie);
//        movies.add(movie1);
//        assertThat(peliculaCrudRepository.findAllByFechaCreacionAsc().get())
//                .usingRecursiveComparison()
//                .ignoringFields("genero", "calificacion", "personajePeliculas")
//                .isEqualTo(movies);
//    }
//
//
//    @Test
//    void get_all_movies_by_creation_date_sorted_desc() {
//        List<Movie> movies = new ArrayList<>();
//        movies.add(movie1);
//        movies.add(movie);
//        assertThat(peliculaCrudRepository.findAllByFechaCreacionDesc().get())
//                .usingRecursiveComparison()
//                .ignoringFields("genero", "calificacion", "personajePeliculas")
//                .isEqualTo(movies);
//    }
//

}