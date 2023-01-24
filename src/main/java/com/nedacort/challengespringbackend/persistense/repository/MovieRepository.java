package com.nedacort.challengespringbackend.persistense.repository;

import com.nedacort.challengespringbackend.domain.MovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {

    List<MovieDto> getAll();

    Optional<MovieDto> getById(Integer id);


    MovieDto save(MovieDto movieDto);

    void delete(Integer id);
}
