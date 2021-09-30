package com.nedacort.challengespringbackend.domain.service;

import com.nedacort.challengespringbackend.domain.PersonageDto;
import com.nedacort.challengespringbackend.domain.PersonageDtoDetail;
import com.nedacort.challengespringbackend.domain.PersonageDtoLimited;
import com.nedacort.challengespringbackend.domain.PersonageMovieDto;
import com.nedacort.challengespringbackend.domain.repository.PersonageDtoLimitedRepository;
import com.nedacort.challengespringbackend.domain.repository.PersonageDtoRepository;
import com.nedacort.challengespringbackend.domain.repository.PersonageMovieDtoRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@NoArgsConstructor
@Service
public class PersonageService {

    @Autowired
    private PersonageDtoRepository personageDtoRepository;

    @Autowired
    private PersonageDtoLimitedRepository personageDtoLimitedRepository;

    @Autowired
    private PersonageMovieDtoRepository personageMovieDtoRepository;


    public Optional<List<PersonageMovieDto>> getAllPersonagesAndMovies() {
        return personageMovieDtoRepository.findAllPersonagesAndMovies();
    }

    public List<PersonageDtoLimited> getAllNameAndImage() {
        return personageDtoLimitedRepository.getAllLimited();
    }

    public Optional<PersonageDto> getPersonageById(Integer id) {
        return personageDtoRepository.getPersonageById(id);
    }


    public Optional<List<PersonageMovieDto>> findAllByName(String name) {
        return personageMovieDtoRepository.findAllByName(name);
    }

    public Optional<List<PersonageMovieDto>> findAllByAge(Integer age) {
        return personageMovieDtoRepository.findAllByAge(age);
    }

    public Optional<List<PersonageMovieDto>> findAllByIdMovie(Integer id) {
        return personageMovieDtoRepository.findAllByIdMovie(id);
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
