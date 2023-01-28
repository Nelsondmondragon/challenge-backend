package com.nedacort.challengespringbackend.service;

import com.nedacort.challengespringbackend.domain.MovieListDto;

import java.util.List;

public interface MovieService {


    List<MovieListDto> findAll();
}
