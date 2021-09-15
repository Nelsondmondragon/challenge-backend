package com.nedacort.challengespringbackend.persistence;

import com.nedacort.challengespringbackend.domain.MovieDto;
import com.nedacort.challengespringbackend.domain.MovieDtoLimited;
import com.nedacort.challengespringbackend.domain.MoviePersonageDto;
import com.nedacort.challengespringbackend.domain.PersonageMovieDto;
import com.nedacort.challengespringbackend.domain.repository.MovieDtoLimitedRepository;
import com.nedacort.challengespringbackend.domain.repository.MovieDtoRepository;
import com.nedacort.challengespringbackend.domain.repository.MoviePersonageDtoRepository;
import com.nedacort.challengespringbackend.persistence.crud.PeliculaCrudRepository;
import com.nedacort.challengespringbackend.persistence.crud.PersonajePeliculaCrudRepository;
import com.nedacort.challengespringbackend.persistence.entity.Pelicula;
import com.nedacort.challengespringbackend.persistence.mapper.MovieDtoLimitedMapper;
import com.nedacort.challengespringbackend.persistence.mapper.MovieDtoMapper;
import com.nedacort.challengespringbackend.persistence.mapper.MoviePersonageDtoMapper;
import com.nedacort.challengespringbackend.persistence.mapper.PersonageMovieDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository implements MovieDtoLimitedRepository, MovieDtoRepository, MoviePersonageDtoRepository {

    @Autowired
    private PeliculaCrudRepository peliculaCrudRepository;

    @Autowired
    private PersonajePeliculaCrudRepository personajePeliculaCrudRepository;

    @Autowired
    private MovieDtoLimitedMapper movieDtoLimitedMapper;

    @Autowired
    PersonageMovieDtoMapper personageMovieDtoMapper;

    @Autowired
    private MovieDtoMapper movieDtoMapper;

    @Autowired
    private MoviePersonageDtoMapper moviePersonageDtoMapper;

    @Override
    public List<MovieDtoLimited> getAllLimited() {
        return movieDtoLimitedMapper.toMovieDto1S((List<Pelicula>) peliculaCrudRepository.findAll());
    }

    @Override
    public Optional<MovieDto> getById(Integer id) {
        return peliculaCrudRepository.findById(id)
                .map(pelicula -> movieDtoMapper.toMovieDto(pelicula));
    }

    @Override
    public Optional<List<MovieDto>> getByName(String name) {
        return peliculaCrudRepository.findByName(name)
                .map(peliculas -> movieDtoMapper.toMovieDtos(peliculas));
    }

    @Override
    public Optional<List<MovieDto>> getByIdGenre(Integer id) {
        return peliculaCrudRepository.findByIdGenero(id)
                .map(peliculas -> movieDtoMapper.toMovieDtos(peliculas));
    }

    @Override
    public Optional<List<MovieDto>> findAllByCreationDateDesc() {
        return peliculaCrudRepository.findAllByFechaCreacionDesc()
                .map(peliculas -> movieDtoMapper.toMovieDtos(peliculas));
    }

    @Override
    public Optional<List<MovieDto>> findAllByCreationDateAsc() {
        return peliculaCrudRepository.findAllFechaCreacionAsc()
                .map(peliculas -> movieDtoMapper.toMovieDtos(peliculas));
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        return movieDtoMapper.toMovieDto(peliculaCrudRepository.save(movieDtoMapper.toPelicula(movieDto)));
    }

    @Override
    public void delete(Integer id) {
        peliculaCrudRepository.deleteById(id);
    }

    @Override
    public Optional<List<MoviePersonageDto>> findAllMoviesAndPersonage() {
        return personajePeliculaCrudRepository.findAllPersonajesAndPeliculas()
                .map(personajePeliculas -> moviePersonageDtoMapper.toMoviePersonageDtos(personajePeliculas));
    }
}
