package com.nedacort.challengespringbackend.persistence.crud;


import com.nedacort.challengespringbackend.persistence.entity.PersonajePelicula;
import com.nedacort.challengespringbackend.persistence.entity.PersonajePeliculaPK;
import org.assertj.core.api.Assertions;
import com.nedacort.challengespringbackend.persistence.entity.Personaje;
import com.nedacort.challengespringbackend.persistence.entity.PersonajePelicula;
import com.nedacort.challengespringbackend.persistence.entity.PersonajePeliculaPK;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.RecursiveComparisonAssert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.Collections;


@DataJpaTest
class PersonajePeliculaCrudRepositoryTest {

    @Autowired
    private PersonajePeliculaCrudRepository personajePeliculaCrudRepository;

    @Test
    void get_all_personages_and_movies() {
        PersonajePelicula personajePelicula = PersonajePelicula.builder()
                .id(PersonajePeliculaPK.builder()
                        .idPelicula(1)
                        .idPersonaje(1)
                        .build())
                .build();
        PersonajePelicula personajePelicula1 = PersonajePelicula.builder()
                .id(PersonajePeliculaPK.builder()
                        .idPelicula(2)
                        .idPersonaje(2)
                        .build())
                .build();
        PersonajePelicula personajePelicula2 = PersonajePelicula.builder()
                .id(PersonajePeliculaPK.builder()
                        .idPelicula(2)
                        .idPersonaje(3)
                        .build())
                .build();
        Assertions.assertThat(personajePeliculaCrudRepository.findAllPersonajesAndPeliculas().get())
                .usingRecursiveComparison()
                .ignoringFields("personaje", "pelicula")
                .isEqualTo(Arrays.asList(personajePelicula, personajePelicula1, personajePelicula2));
    }

    @Test

    void get_all_personages_by_name() {


        PersonajePelicula personajePelicula = PersonajePelicula
                .builder()
                .id(PersonajePeliculaPK.builder()
                        .idPersonaje(1)
                        .build())
                .build();


        Assertions.assertThat(personajePeliculaCrudRepository.findAllByNombre("son").get())
                .usingRecursiveComparison()
                .ignoringFields("id.idPelicula", "pelicula", "personaje")
                .isEqualTo(Arrays.asList(personajePelicula));


    }

    @Test
    void get_all_personages_by_age() {

        PersonajePelicula personajePelicula = PersonajePelicula
                .builder()
                .id(PersonajePeliculaPK.builder()
                        .idPersonaje(1)
                        .build())
                .build();

        Assertions.assertThat(personajePeliculaCrudRepository.findAllByEdad(21).get())
                .usingRecursiveComparison()
                .ignoringFields("id.idPelicula", "pelicula", "personaje")
                .isEqualTo(Arrays.asList(personajePelicula));
    }

    @Test
    void get_all_personages_by_movie_id() {

        PersonajePelicula personajePelicula = PersonajePelicula.builder()
                .id(PersonajePeliculaPK.builder()
                        .idPelicula(2)
                        .idPersonaje(2)
                        .build())
                .build();
        PersonajePelicula personajePelicula1 = PersonajePelicula.builder()
                .id(PersonajePeliculaPK.builder()
                        .idPelicula(2)
                        .idPersonaje(3)
                        .build())
                .build();

        Assertions.assertThat(personajePeliculaCrudRepository.findAllByIdPelicula(2).get())
                .usingRecursiveComparison()
                .ignoringFields("pelicula", "personaje")
                .isEqualTo(Arrays.asList(personajePelicula, personajePelicula1));

    }
}