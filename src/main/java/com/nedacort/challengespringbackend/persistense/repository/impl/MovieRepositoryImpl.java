package com.nedacort.challengespringbackend.persistense.repository.impl;

import com.nedacort.challengespringbackend.domain.MovieDetailsDto;
import com.nedacort.challengespringbackend.domain.MovieDto;
import com.nedacort.challengespringbackend.domain.MovieListDto;
import com.nedacort.challengespringbackend.persistense.mapper.MovieMapper;
import com.nedacort.challengespringbackend.persistense.repository.MovieRepository;
import com.nedacort.challengespringbackend.persistense.repositoryjpa.MovieJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepositoryImpl implements MovieRepository {


    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieJpaRepository movieJpaRepository;

    @Override
    public List<MovieListDto> findAll() {
        return movieMapper.toMovieListDtos(movieJpaRepository.findAll());
    }

    @Override
    public boolean existsById(Long id) {
        return movieJpaRepository.existsById(id);
    }

    @Override
    public Optional<MovieDetailsDto> findById(Long id) {
        return movieJpaRepository.findById(id).map(movie -> movieMapper.toMovieDetailsDto(movie));
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
// implements MovieDtoLimitedRepository, MovieDtoRepository, MoviePersonageDtoRepository {
//
//    @Autowired
//    private MovieCrudRepository peliculaCrudRepository;
//
//    @Autowired
//    private PersonajePeliculaCrudRepository personajePeliculaCrudRepository;
//
//    @Autowired
//    private MovieDtoLimitedMapper movieDtoLimitedMapper;
//
//    @Autowired
//    PersonageMovieDtoMapper personageMovieDtoMapper;
//
//    @Autowired
//    private MovieDtoMapper movieDtoMapper;
//
//    @Autowired
//    private MoviePersonageDtoMapper moviePersonageDtoMapper;
//
//    @Override
//    public List<MovieDtoLimited> getAllLimited() {
//        return movieDtoLimitedMapper.toMovieDtoLimiteds((List<Movie>) peliculaCrudRepository.findAll());
//    }
//
//    @Override
//    public Optional<MovieDto> getById(Integer id) {
//        return peliculaCrudRepository.findById(id)
//                .map(pelicula -> movieDtoMapper.toMovieDto(pelicula));
//    }
//
//    @Override
//    public Optional<List<MovieDto>> getByName(String name) {
//        return peliculaCrudRepository.findByName(name)
//                .map(peliculas -> movieDtoMapper.toMovieDtos(peliculas));
//    }
//
//    @Override
//    public Optional<List<MovieDto>> getByIdGenre(Integer id) {
//        return peliculaCrudRepository.findByIdGenero(id)
//                .map(peliculas -> movieDtoMapper.toMovieDtos(peliculas));
//    }
//
//    @Override
//    public Optional<List<MovieDto>> findAllByCreationDateDesc() {
//        return peliculaCrudRepository.findAllByFechaCreacionDesc()
//                .map(peliculas -> movieDtoMapper.toMovieDtos(peliculas));
//    }
//
//    @Override
//    public Optional<List<MovieDto>> findAllByCreationDateAsc() {
//        return peliculaCrudRepository.findAllByFechaCreacionAsc()
//                .map(peliculas -> movieDtoMapper.toMovieDtos(peliculas));
//    }
//
//    @Override
//    public MovieDto save(MovieDto movieDto) {
//        return movieDtoMapper.toMovieDto(peliculaCrudRepository.save(movieDtoMapper.toPelicula(movieDto)));
//    }
//
//    @Override
//    public void delete(Integer id) {
//        peliculaCrudRepository.deleteById(id);
//    }
//
//    @Override
//    public Optional<List<MoviePersonageDto>> findAllMoviesAndPersonage() {
//        return personajePeliculaCrudRepository.findAllPersonajesAndPeliculas()
//                .map(personajePeliculas -> moviePersonageDtoMapper.toMoviePersonageDtos(personajePeliculas));
//    }
//}
