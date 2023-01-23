package com.nedacort.challengespringbackend.persistence;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MovieJpaRepositoryTest {

//    @Mock
//    private MovieRepository peliculaCrudRepository;
//
//    @Mock
//    private PersonajePeliculaCrudRepository personajePeliculaCrudRepository;
//
//    @Mock
//    private MovieDtoLimitedMapper movieDtoLimitedMapper;
//
//    @Mock
//    private MovieDtoMapper movieDtoMapper;
//
//    @InjectMocks
//    private com.nedacort.challengespringbackend.services.MovieRepository movieRepository;
//
//    @Captor
//    ArgumentCaptor<Movie> argumentCaptor;
//
//
//    @Test
//    void get_all_movies_by_image_tittle_and_create_date() {
//        movieRepository.getAllLimited();
//        verify(peliculaCrudRepository).findAll();
//    }
//
//    @Test
//    void get_movie_by_id() {
//        movieRepository.getById(1);
//        verify(peliculaCrudRepository).findById(1);
//    }
//
//    @Test
//    void get_all_the_movies_that_contain_the_name() {
//        movieRepository.getByName("nelson");
//        verify(peliculaCrudRepository).findByName("nelson");
//    }
//
//    @Test
//    void get_all_the_movies_by_id_genre() {
//        movieRepository.getByIdGenre(1);
//        verify(peliculaCrudRepository).findByIdGenero(1);
//    }
//
//    @Test
//    void find_all_movies_by_creation_date_sorted_desc() {
//        movieRepository.findAllByCreationDateDesc();
//        verify(peliculaCrudRepository).findAllByFechaCreacionDesc();
//    }
//
//    @Test
//    void find_all_movies_by_creation_date_sorted_asc() {
//        movieRepository.findAllByCreationDateAsc();
//        verify(peliculaCrudRepository).findAllByFechaCreacionAsc();
//    }
//
//    @Test
//    void save() {
//        MovieDto movieDto = MovieDto.builder()
//                .id(1)
//                .image(new byte[2])
//                .tittle("Roo")
//                .creationDate(LocalDateTime.now())
//                .idGenus(1)
//                .idQualification(1)
//                .build();
//
//        Mockito.when(movieDtoMapper.toPelicula(movieDto)).thenReturn(
//                Movie.builder()
//                        .idMovie(movieDto.getId())
//                        .image(movieDto.getImage())
//                        .title(movieDto.getTittle())
//                        .fechaCreacion(movieDto.getCreationDate())
//                        .idGenero(movieDto.getIdGenus())
//                        .idCalificacion(movieDto.getIdQualification())
//                        .build()
//        );
//        movieRepository.save(movieDto);
//        argumentCaptor =
//                ArgumentCaptor.forClass(Movie.class);
//
//        verify(peliculaCrudRepository)
//                .save(argumentCaptor.capture());
//
//
//        Assertions.assertThat(movieDto.getId()).isEqualTo(argumentCaptor.getValue().getIdMovie());
//    }
//
//    @Test
//    void delete() {
//        Integer id = 1;
//        movieRepository.delete(id);
//        verify(peliculaCrudRepository).deleteById(id);
//    }
//
//    @Test
//    void get_all_movies_with_their_personages() {
//        movieRepository.findAllMoviesAndPersonage();
//        verify(personajePeliculaCrudRepository).findAllPersonajesAndPeliculas();
//    }
}