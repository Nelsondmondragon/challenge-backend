package com.nedacort.challengespringbackend.service;

import com.nedacort.challengespringbackend.domain.MovieDetailsDto;
import com.nedacort.challengespringbackend.domain.MovieDto;
import com.nedacort.challengespringbackend.domain.MovieListDto;

import java.util.List;
import java.util.Optional;

public interface MovieService {


    List<MovieListDto> findAll();


    MovieDetailsDto findById(Long id);

    boolean existsById(Long id);
}
