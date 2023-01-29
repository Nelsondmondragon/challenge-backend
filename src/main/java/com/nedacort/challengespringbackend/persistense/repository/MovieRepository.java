package com.nedacort.challengespringbackend.persistense.repository;

import com.nedacort.challengespringbackend.domain.MovieDetailsDto;
import com.nedacort.challengespringbackend.domain.MovieDto;
import com.nedacort.challengespringbackend.domain.MovieListDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository {

    List<MovieListDto> findAll();

    boolean existsById(Long id);

    Optional<MovieDetailsDto> findById(Long id);

    MovieDto save(MovieDto movieDto);

    void delete(Integer id);
}
