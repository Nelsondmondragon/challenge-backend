package com.nedacort.challengespringbackend.domain.repository;

import com.nedacort.challengespringbackend.domain.MovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieDtoRepository {

    List<MovieDto> getAll();

    Optional<MovieDto> getById(Integer id);

    MovieDto save(MovieDto movieDto);

    void delete(Integer id);
}
