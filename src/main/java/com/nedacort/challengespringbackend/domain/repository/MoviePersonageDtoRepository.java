package com.nedacort.challengespringbackend.domain.repository;

import com.nedacort.challengespringbackend.domain.MoviePersonageDto;
import com.nedacort.challengespringbackend.domain.PersonageMovieDto;

import java.util.List;
import java.util.Optional;

public interface MoviePersonageDtoRepository {

    Optional<List<MoviePersonageDto>> findAllMoviesAndPersonage();

}
