package com.nedacort.challengespringbackend.domain.service;

import com.nedacort.challengespringbackend.domain.PersonageDto;
import com.nedacort.challengespringbackend.domain.PersonageDtoDetail;
import com.nedacort.challengespringbackend.domain.PersonageDtoLimited;
import com.nedacort.challengespringbackend.domain.PersonageMovieDto;
import com.nedacort.challengespringbackend.domain.repository.PersonageDtoLimitedRepository;
import com.nedacort.challengespringbackend.domain.repository.PersonageDtoRepository;
import com.nedacort.challengespringbackend.domain.repository.PersonageMovieDtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonageService {

    @Autowired
    private PersonageDtoRepository personageDtoRepository;

    @Autowired
    private PersonageDtoLimitedRepository personageDtoLimitedRepository;

    @Autowired
    private PersonageMovieDtoRepository personageMovieDtoRepository;

    public List<PersonageDto> getAll() {
        return personageDtoRepository.getAll();
    }

    public Optional<List<PersonageMovieDto>> getAllPersonagesAndMovies() {
        return personageMovieDtoRepository.findAllPersonagesAndMovies();
    }

    public List<PersonageDtoLimited> getAllNameAndImage() {
        return personageDtoLimitedRepository.getAllLimited();
    }

    public Optional<PersonageDto> getPersonageById(Integer id) {
        return personageDtoRepository.getPersonageById(id);
    }


    public PersonageDto save(PersonageDto personageDto) {
        return personageDtoRepository.save(personageDto);
    }

    public boolean delete(Integer id) {
        return getPersonageById(id).map(personageDto -> {
            personageDtoRepository.delete(id);
            return true;
        }).orElse(false);
    }


}
