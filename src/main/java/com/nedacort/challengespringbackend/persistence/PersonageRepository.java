package com.nedacort.challengespringbackend.persistence;

import com.nedacort.challengespringbackend.domain.PersonageDto;
import com.nedacort.challengespringbackend.domain.PersonageDtoDetail;
import com.nedacort.challengespringbackend.domain.PersonageDtoLimited;
import com.nedacort.challengespringbackend.domain.PersonageMovieDto;
import com.nedacort.challengespringbackend.domain.repository.PersonageDtoLimitedRepository;
import com.nedacort.challengespringbackend.domain.repository.PersonageDtoRepository;
import com.nedacort.challengespringbackend.domain.repository.PersonageMovieDtoRepository;
import com.nedacort.challengespringbackend.persistence.crud.PersonajeCrudRepository;
import com.nedacort.challengespringbackend.persistence.crud.PersonajePeliculaCrudRepository;
import com.nedacort.challengespringbackend.persistence.entity.Personaje;
import com.nedacort.challengespringbackend.persistence.mapper.PersonageDtoLimitedMapper;
import com.nedacort.challengespringbackend.persistence.mapper.PersonageDtoMapper;
import com.nedacort.challengespringbackend.persistence.mapper.PersonageMovieDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonageRepository implements PersonageDtoRepository, PersonageDtoLimitedRepository, PersonageMovieDtoRepository {

    @Autowired
    private PersonajeCrudRepository personajeCrudRepository;

    @Autowired
    private PersonajePeliculaCrudRepository personajePeliculaCrudRepository;

    @Autowired
    private PersonageDtoMapper personageDtoMapper;

    @Autowired
    private PersonageDtoLimitedMapper personageDtoLimitedMapper;

    @Autowired
    private PersonageMovieDtoMapper personageMovieDtoMapper;

    @Override
    public List<PersonageDto> getAll() {
        return personageDtoMapper.toPersonageDtos((List<Personaje>) personajeCrudRepository.findAll());
    }

    @Override
    public List<PersonageDtoLimited> getAllLimited() {
        return personageDtoLimitedMapper.toPersonageDto1S((List<Personaje>) personajeCrudRepository.findAll());
    }

    @Override
    public Optional<PersonageDto> getPersonageById(Integer id) {
        return personajeCrudRepository.findById(id)
                .map(personaje -> personageDtoMapper.toPersonageDto(personaje));
    }

    @Override
    public Optional<List<PersonageMovieDto>> findAllPersonagesAndMovies() {

        return personajePeliculaCrudRepository.findAllPersonajesAndPeliculas()
                .map(personajePeliculas -> personageMovieDtoMapper.toPersonageMovieDtos(personajePeliculas));
    }

    @Override
    public Optional<List<PersonageMovieDto>> findAllByName(String name) {
        return personajePeliculaCrudRepository.findAllByNombre(name)
                .map(personajePeliculas -> personageMovieDtoMapper.toPersonageMovieDtos(personajePeliculas));
    }

    @Override
    public Optional<List<PersonageMovieDto>> findAllByAge(Integer age) {
        return personajePeliculaCrudRepository.findAllByEdad(age)
                .map(personajePeliculas -> personageMovieDtoMapper.toPersonageMovieDtos(personajePeliculas));
    }


    @Override
    public Optional<List<PersonageMovieDto>> findAllByIdMovie(Integer id) {
        return personajePeliculaCrudRepository.findAllByIdPelicula(id)
                .map(personajePeliculas -> personageMovieDtoMapper.toPersonageMovieDtos(personajePeliculas));
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
