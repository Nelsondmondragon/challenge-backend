package com.nedacort.challengespringbackend.domain.service;

import com.nedacort.challengespringbackend.domain.MovieDto;
import com.nedacort.challengespringbackend.domain.MovieDtoDetail;
import com.nedacort.challengespringbackend.domain.MovieDtoLimited;
import com.nedacort.challengespringbackend.domain.MoviePersonageDto;
import com.nedacort.challengespringbackend.domain.repository.MovieDtoLimitedRepository;
import com.nedacort.challengespringbackend.domain.repository.MovieDtoRepository;
import com.nedacort.challengespringbackend.domain.repository.MoviePersonageDtoRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Service
public class MovieService {

    @Autowired
    private MovieDtoLimitedRepository movieDtoLimitedRepository;

    @Autowired
    private MoviePersonageDtoRepository moviePersonageDtoRepository;

    @Autowired
    private MovieDtoRepository movieDtoRepository;

    public Optional<List<MoviePersonageDto>> getAllMovieAndPersonage() {
        return moviePersonageDtoRepository.findAllMoviesAndPersonage();
    }

    public List<MovieDtoLimited> getAllLimited() {
        return movieDtoLimitedRepository.getAllLimited();
    }

    public Optional<MovieDto> getById(Integer id) {
        return movieDtoRepository.getById(id);
    }

    public Optional<List<MovieDto>> getByName(String name) {
        return movieDtoRepository.getByName(name);
    }

    public Optional<List<MovieDto>> getByIdGenre(Integer id) {
        return movieDtoRepository.getByIdGenre(id);
    }

    public Optional<List<MovieDto>> findAllByCreationDateDesc() {
        return movieDtoRepository.findAllByCreationDateDesc();
    }

    public Optional<List<MovieDto>> findAllByCreationDateAsc() {
        return movieDtoRepository.findAllByCreationDateAsc();
    }

    public MovieDto save(MovieDto movieDto) {
        return movieDtoRepository.save(movieDto);
    }

    public boolean delete(Integer id) {
        return getById(id).map(personageDto -> {
            movieDtoRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
