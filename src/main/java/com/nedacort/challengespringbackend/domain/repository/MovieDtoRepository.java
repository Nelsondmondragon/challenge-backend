package com.nedacort.challengespringbackend.domain.repository;

import com.nedacort.challengespringbackend.domain.MovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieDtoRepository {
    Optional<MovieDto> getById(Integer id);

    Optional<List<MovieDto>> getByName(String name);

    Optional<List<MovieDto>> getByIdGenre(Integer id);

    Optional<List<MovieDto>> findAllByCreationDateDesc();

    Optional<List<MovieDto>> findAllByCreationDateAsc();

    MovieDto save(MovieDto movieDto);

    void delete(Integer id);
}
