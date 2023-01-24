package com.nedacort.challengespringbackend.domain.service;


import com.nedacort.challengespringbackend.domain.CharacterDto;
import com.nedacort.challengespringbackend.persistense.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public List<CharacterDto> getAll() {
        return characterRepository.getAll();
    }
//
//    public List<PersonageDtoLimited> getAllNameAndImage() {
//        return personageDtoLimitedRepository.getAllLimited();
//    }
//
//    public Optional<PersonageDto> getPersonageById(Integer id) {
//        return personageDtoRepository.getPersonageById(id);
//    }
//
//
//    public Optional<List<PersonageMovieDto>> findAllByName(String name) {
//        return personageMovieDtoRepository.findAllByName(name);
//    }
//
//    public Optional<List<PersonageMovieDto>> findAllByAge(Integer age) {
//        return personageMovieDtoRepository.findAllByAge(age);
//    }
//
//    public Optional<List<PersonageMovieDto>> findAllByIdMovie(Integer id) {
//        return personageMovieDtoRepository.findAllByIdMovie(id);
//    }

//    public PersonageDto save(PersonageDto personageDto) {
//        return personageDtoRepository.save(personageDto);
//    }
//
//    public boolean delete(Integer id) {
//        return getPersonageById(id).map(personageDto -> {
//            personageDtoRepository.delete(id);
//            return true;
//        }).orElse(false);
//    }


}
