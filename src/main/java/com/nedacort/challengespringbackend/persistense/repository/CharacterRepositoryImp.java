package com.nedacort.challengespringbackend.persistense.repository;

import com.nedacort.challengespringbackend.domain.CharacterDto;
import com.nedacort.challengespringbackend.persistense.mapper.CharacterMapper;
import com.nedacort.challengespringbackend.persistense.repositoryjpa.CharacterJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CharacterRepositoryImp implements CharacterRepository{

    @Autowired
    private CharacterJpaRepository characterJpaRepository;

    @Autowired
    private CharacterMapper  characterMapper;


    @Override
    public List<CharacterDto> getAll() {
        return characterMapper.toCharacterDtos( characterJpaRepository.findAll());
    }

    @Override
    public Optional<CharacterDto> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public CharacterDto save(CharacterDto characterDto) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

//    @Autowired
//    private CharacterJpaRepository characterJpaRepository;
//
//    @Override
//    public List<CharacterDto> getAllLimited() {
//        return personageDtoLimitedMapper.toPersonageDtoLimiteds((List<Character>) characterJpaRepository.findAll());
//    }
//
//    @Override
//    public Optional<PersonageDto> getPersonageById(Integer id) {
//        return characterJpaRepository.findById(id)
//                .map(personaje -> personageDtoMapper.toPersonageDto(personaje));
//    }
//
//    @Override
//    public Optional<List<PersonageMovieDto>> findAllPersonagesAndMovies() {
//        return personajePeliculaCrudRepository.findAllPersonajesAndPeliculas()
//                .map(personajePeliculas -> personageMovieDtoMapper.toPersonageMovieDtos(personajePeliculas));
//    }
//
//    @Override
//    public Optional<List<PersonageMovieDto>> findAllByName(String name) {
//        return personajePeliculaCrudRepository.findAllByNombre(name)
//                .map(personajePeliculas -> personageMovieDtoMapper.toPersonageMovieDtos(personajePeliculas));
//    }
//
//    @Override
//    public Optional<List<PersonageMovieDto>> findAllByAge(Integer age) {
//        return personajePeliculaCrudRepository.findAllByEdad(age)
//                .map(personajePeliculas -> personageMovieDtoMapper.toPersonageMovieDtos(personajePeliculas));
//    }
//
//
//    @Override
//    public Optional<List<PersonageMovieDto>> findAllByIdMovie(Integer id) {
//        return personajePeliculaCrudRepository.findAllByIdPelicula(id)
//                .map(personajePeliculas -> personageMovieDtoMapper.toPersonageMovieDtos(personajePeliculas));
//    }
//
//    @Override
//    public PersonageDto save(PersonageDto personageDto) {
//        return personageDtoMapper.toPersonageDto(characterJpaRepository.save(personageDtoMapper.toPersonaje(personageDto)));
//    }
//
//    @Override
//    public void delete(Integer id) {
//        characterJpaRepository.deleteById(id);
//    }
//

}
