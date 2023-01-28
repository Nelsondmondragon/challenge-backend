package com.nedacort.challengespringbackend.service.impl;

import com.nedacort.challengespringbackend.domain.MovieListDto;
import com.nedacort.challengespringbackend.persistense.repository.MovieRepository;
import com.nedacort.challengespringbackend.service.CharacterService;
import com.nedacort.challengespringbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {


    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<MovieListDto> findAll() {
        return movieRepository.getAll();
    }
//
//    @Autowired
//    private MovieDtoLimitedRepository movieDtoLimitedRepository;
//
//    @Autowired
//    private MoviePersonageDtoRepository moviePersonageDtoRepository;
//
//    @Autowired
//    private MovieDtoRepository movieDtoRepository;
//
//    public Optional<List<MoviePersonageDto>> getAllMovieAndPersonage() {
//        return moviePersonageDtoRepository.findAllMoviesAndPersonage();
//    }
//
//    public List<MovieDtoLimited> getAllLimited() {
//        return movieDtoLimitedRepository.getAllLimited();
//    }
//
//    public Optional<MovieDto> getById(Integer id) {
//        return movieDtoRepository.getById(id);
//    }
//
//    public Optional<List<MovieDto>> getByName(String name) {
//        return movieDtoRepository.getByName(name);
//    }
//
//    public Optional<List<MovieDto>> getByIdGenre(Integer id) {
//        return movieDtoRepository.getByIdGenre(id);
//    }
//
//    public Optional<List<MovieDto>> findAllByCreationDateDesc() {
//        return movieDtoRepository.findAllByCreationDateDesc();
//    }
//
//    public Optional<List<MovieDto>> findAllByCreationDateAsc() {
//        return movieDtoRepository.findAllByCreationDateAsc();
//    }
//
//    public MovieDto save(MovieDto movieDto) {
//        return movieDtoRepository.save(movieDto);
//    }
//
//    public boolean delete(Integer id) {
//        return getById(id).map(personageDto -> {
//            movieDtoRepository.delete(id);
//            return true;
//        }).orElse(false);
//    }
}
