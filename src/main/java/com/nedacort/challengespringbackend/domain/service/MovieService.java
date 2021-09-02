package com.nedacort.challengespringbackend.domain.service;

import com.nedacort.challengespringbackend.domain.MovieDto;
import com.nedacort.challengespringbackend.domain.MovieDtoDetail;
import com.nedacort.challengespringbackend.domain.MovieDtoLimited;
import com.nedacort.challengespringbackend.domain.repository.MovieDtoLimitedRepository;
import com.nedacort.challengespringbackend.domain.repository.MovieDtoDetailRepository;
import com.nedacort.challengespringbackend.domain.repository.MovieDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieDtoLimitedRepository movieDtoLimitedRepository;

    @Autowired
    private MovieDtoDetailRepository movieDtoDetailRepository;

    @Autowired
    private MovieDtoRepository movieDtoRepository;

    public List<MovieDtoDetail> getAllDetails() {
        return movieDtoDetailRepository.getAllDetails();
    }

    public List<MovieDtoLimited> getAllLimited() {
        return movieDtoLimitedRepository.getAllLimited();
    }

    public Optional<MovieDto> getById(Integer id) {
        return movieDtoRepository.getById(id);
    }


    public MovieDto save(MovieDto movieDto) {
        return movieDtoRepository.save(movieDto);
    }

    public boolean delete(Integer id) {
        return getById(id).map(personageDto -> {
            movieDtoRepository.delete(id);
            return true;
        }).orElse(false);
    }
}
