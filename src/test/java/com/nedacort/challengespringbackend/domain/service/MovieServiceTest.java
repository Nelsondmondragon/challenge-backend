package com.nedacort.challengespringbackend.domain.service;

import com.nedacort.challengespringbackend.domain.MovieDto;
import com.nedacort.challengespringbackend.domain.repository.MovieDtoLimitedRepository;
import com.nedacort.challengespringbackend.domain.repository.MovieDtoRepository;
import com.nedacort.challengespringbackend.domain.repository.MoviePersonageDtoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class MovieServiceTest {


    @Mock
    private MovieDtoLimitedRepository movieDtoLimitedRepository;

    @Mock
    private MoviePersonageDtoRepository moviePersonageDtoRepository;

    @Mock
    private MovieDtoRepository movieDtoRepository;

    @InjectMocks
    private MovieService movieService;


    @Captor
    private ArgumentCaptor<MovieDto> argumentCaptor;

    @Test
    void get_all_movie_and_personage() {
        movieService.getAllMovieAndPersonage();
        verify(moviePersonageDtoRepository).findAllMoviesAndPersonage();
    }

    @Test
    void get_all_movies_by_image_tittle_and_created_date() {
        movieService.getAllLimited();
        verify(movieDtoLimitedRepository).getAllLimited();
    }

    @Test
    void get_movie_by_id() {
        movieService.getById(1);
        verify(movieDtoRepository).getById(1);
    }

    @Test
    void get_movie_by_name() {
        movieService.getByName("It");
        verify(movieDtoRepository).getByName("It");
    }

    @Test
    void get_movie_by_id_genre() {
        movieService.getByIdGenre(1);
        verify(movieDtoRepository).getByIdGenre(1);
    }

    @Test
    void get_all_movies_by_create_date_sorted_desc() {
        movieService.findAllByCreationDateDesc();
        verify(movieDtoRepository).findAllByCreationDateDesc();
    }

    @Test
    void get_all_movies_by_create_date_sorted_asc() {
        movieService.findAllByCreationDateAsc();
        verify(movieDtoRepository).findAllByCreationDateAsc();
    }

    @Test
    void save() {
        MovieDto movieDto = MovieDto.builder()
                .id(1)
                .tittle("It")
                .creationDate(LocalDateTime.now())
                .idGenus(1)
                .idQualification(1)
                .build();
        movieService.save(movieDto);
        argumentCaptor = ArgumentCaptor.forClass(MovieDto.class);
        verify(movieDtoRepository).save(argumentCaptor.capture());
        assertThat(movieDto).isEqualTo(argumentCaptor.getValue());

    }

    @Test
    void delete() {
        MovieDto movieDto = MovieDto.builder()
                .id(1)
                .tittle("It")
                .creationDate(LocalDateTime.now())
                .idGenus(1)
                .idQualification(1)
                .build();
        Mockito.when(movieService.getById(movieDto.getId()))
                .thenReturn(Optional.of(movieDto));
        movieService.delete(movieDto.getId());
        verify(movieDtoRepository).delete(movieDto.getId());
    }
}