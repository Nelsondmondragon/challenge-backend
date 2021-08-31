package com.nedacort.challengespringbackend.persistence;

import com.nedacort.challengespringbackend.domain.PersonageDto;
import com.nedacort.challengespringbackend.domain.PersonageDto1;
import com.nedacort.challengespringbackend.domain.repository.MovieDtoRepository;
import com.nedacort.challengespringbackend.domain.repository.PersonageDto1Repository;
import com.nedacort.challengespringbackend.domain.repository.PersonageDtoRepository;
import com.nedacort.challengespringbackend.persistence.crud.PersonajeCrudRepository;
import com.nedacort.challengespringbackend.persistence.entity.Personaje;
import com.nedacort.challengespringbackend.persistence.mapper.PersonageDto1Mapper;
import com.nedacort.challengespringbackend.persistence.mapper.PersonageDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonageRepository implements PersonageDtoRepository, PersonageDto1Repository {

    @Autowired
    private PersonajeCrudRepository personajeCrudRepository;

    @Autowired
    private PersonageDtoMapper personageDtoMapper;

    @Autowired
    private PersonageDto1Mapper personageDto1Mapper;

    @Override
    public List<PersonageDto> getAll() {
        return personageDtoMapper.toPersonageDtos((List<Personaje>) personajeCrudRepository.findAll());
    }

    @Override
    public List<PersonageDto1> getAllNameAndImage() {
        return personageDto1Mapper.toPersonageDto1S((List<Personaje>) personajeCrudRepository.findAll());
    }

    @Override
    public Optional<PersonageDto> getPersonageById(Integer id) {
        return personajeCrudRepository.findById(id)
                .map(personaje -> personageDtoMapper.toPersonageDto(personaje));
    }


    @Override
    public Optional<List<PersonageDto>> getAllPersonajesAndPeliculas() {
        return personajeCrudRepository.findAllPersonajesAndPeliculas().map(
                personajes -> personageDtoMapper.toPersonageDtos(personajes)
        );
    }


    @Override
    public PersonageDto save(PersonageDto personageDto) {
        return personageDtoMapper.toPersonageDto(personajeCrudRepository.save(personageDtoMapper.toPersonaje(personageDto)));
    }

    @Override
    public void delete(Integer id) {
        personajeCrudRepository.deleteById(id);
    }


}
