package com.nedacort.challengespringbackend.domain.repository;

import com.nedacort.challengespringbackend.domain.MovieDto;

public interface MovieDtoRepository {

    MovieDto save(MovieDto movieDto);

    void delete(Integer id);
}
