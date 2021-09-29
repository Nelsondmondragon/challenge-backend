package com.nedacort.challengespringbackend.persistence;

import com.nedacort.challengespringbackend.domain.PersonageDto;
import com.nedacort.challengespringbackend.persistence.crud.PersonajeCrudRepository;
import com.nedacort.challengespringbackend.persistence.crud.PersonajePeliculaCrudRepository;
import com.nedacort.challengespringbackend.persistence.entity.Personaje;
import com.nedacort.challengespringbackend.persistence.mapper.PersonageDtoLimitedMapper;
import com.nedacort.challengespringbackend.persistence.mapper.PersonageDtoMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonageRepositoryTest {


    @Mock
    private PersonajeCrudRepository personajeCrudRepository;

    @Mock
    private PersonajePeliculaCrudRepository personajePeliculaCrudRepository;

    @Mock
    private PersonageDtoMapper personageDtoMapper;

    @Mock
    private PersonageDtoLimitedMapper personageDtoLimitedMapper;

    @InjectMocks
    private PersonageRepository personageRepository;

    @Captor
    private ArgumentCaptor<Personaje> argumentCaptor;

    private static Integer id = 1;

    private static Integer age = 21;

    private static String name = "Nelson";

    @Test
    void get_all_personages_with_the_image_and_the_name() {
        personageRepository.getAllLimited();
        verify(personajeCrudRepository).findAll();
    }

    @Test
    void get_personage_by_id() {
        personageRepository.getPersonageById(id);
        verify(personajeCrudRepository).findById(id);
    }

    @Test
    void get_all_personages_and_movies() {
        personageRepository.findAllPersonagesAndMovies();
        verify(personajePeliculaCrudRepository).findAllPersonajesAndPeliculas();
    }

    @Test
    void get_all_personages_by_name() {
        personageRepository.findAllByName(name);
        verify(personajePeliculaCrudRepository).findAllByNombre(name);
    }

    @Test
    void get_all_personages_by_age() {
        personageRepository.findAllByAge(age);
        verify(personajePeliculaCrudRepository).findAllByEdad(age);
    }

    @Test
    void get_all_personages_by_id_movie() {
        personageRepository.findAllByIdMovie(id);
        verify(personajePeliculaCrudRepository).findAllByIdPelicula(id);
    }

    @Test
    void save() {
        PersonageDto personageDto = PersonageDto.builder()
                .id(id)
                .image(new byte[2])
                .name("Nelson")
                .age(12)
                .peso(234)
                .history("Ojo con esoo")
                .build();

        Mockito.when(personageDtoMapper.toPersonaje(personageDto)).thenReturn(
                Personaje.builder()
                        .id(personageDto.getId())
                        .imagen(personageDto.getImage())
                        .nombre(personageDto.getName())
                        .edad(personageDto.getAge())
                        .historia(personageDto.getHistory())
                        .build()
        );

        personageRepository.save(personageDto);
        argumentCaptor = ArgumentCaptor.forClass(Personaje.class);
        verify(personajeCrudRepository).save(argumentCaptor.capture());
        Assertions.assertThat(personageDto.getId()).isEqualTo(argumentCaptor.getValue().getId());

    }

    @Test
    void delete() {
        personageRepository.delete(id);
        verify(personajeCrudRepository).deleteById(id);
    }
}