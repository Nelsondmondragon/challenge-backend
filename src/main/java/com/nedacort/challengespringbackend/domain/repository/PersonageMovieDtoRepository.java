package com.nedacort.challengespringbackend.domain.repository;

import com.nedacort.challengespringbackend.domain.PersonageDtoDetail;
import com.nedacort.challengespringbackend.domain.PersonageMovieDto;

import java.util.List;
import java.util.Optional;

public interface PersonageMovieDtoRepository {

    Optional<List<PersonageMovieDto>> findAllPersonagesAndMovies();
}
