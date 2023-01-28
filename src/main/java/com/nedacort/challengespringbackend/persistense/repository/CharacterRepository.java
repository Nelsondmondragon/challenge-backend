package com.nedacort.challengespringbackend.persistense.repository;

import com.nedacort.challengespringbackend.domain.CharacterDetailsDto;
import com.nedacort.challengespringbackend.domain.CharacterDto;
import com.nedacort.challengespringbackend.domain.CharacterIdMovieDto;
import com.nedacort.challengespringbackend.domain.CharacterListDto;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository {

    List<CharacterListDto> getAll();

    List<CharacterDto> findByName(String name);

    List<CharacterDto> findByAge(Integer age);

    List<CharacterDetailsDto> findByIdMovie(Long idMovie);

    boolean existsById(Long Id);

    //    CharacterDto find
    Optional<CharacterDetailsDto> findById(Long id);


    CharacterDto update(Long id, CharacterDto characterDto);

    CharacterDetailsDto save(CharacterIdMovieDto characterDto);

    void delete(Long id);
}
