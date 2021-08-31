package com.nedacort.challengespringbackend.domain.service;

import com.nedacort.challengespringbackend.domain.PersonageDto;
import com.nedacort.challengespringbackend.domain.PersonageDto1;
import com.nedacort.challengespringbackend.domain.repository.PersonageDto1Repository;
import com.nedacort.challengespringbackend.domain.repository.PersonageDtoRepository;
import com.nedacort.challengespringbackend.persistence.entity.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonageService {

    @Autowired
    private PersonageDtoRepository personageDtoRepository;

    @Autowired
    private PersonageDto1Repository personageDto1Repository;

    public List<PersonageDto> getAll() {
        return personageDtoRepository.getAll();
    }

    public List<PersonageDto1> getAllNameAndImage() {
        return personageDto1Repository.getAllNameAndImage();
    }

    public Optional<PersonageDto> getPersonageById(Integer id) {
        return personageDtoRepository.getPersonageById(id);
    }


    public Optional<List<PersonageDto>> getAllPersonajesAndPeliculas() {
        return personageDtoRepository.getAllPersonajesAndPeliculas();
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