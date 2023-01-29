package com.nedacort.challengespringbackend.service.impl;

import com.nedacort.challengespringbackend.domain.MovieDto;
import com.nedacort.challengespringbackend.domain.MovieListDto;
import com.nedacort.challengespringbackend.persistense.repository.MovieRepository;
import com.nedacort.challengespringbackend.service.CharacterService;
import com.nedacort.challengespringbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {


    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<MovieListDto> findAll() {
        return movieRepository.getAll();
    }

    @Override
    public Optional<MovieDto> findById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return movieRepository.existsById(id);
    }


}