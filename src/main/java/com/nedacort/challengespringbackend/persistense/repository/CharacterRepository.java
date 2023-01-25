package com.nedacort.challengespringbackend.persistense.repository;

import com.nedacort.challengespringbackend.domain.CharacterDto;
import com.nedacort.challengespringbackend.domain.CharacterListDto;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository {

    List<CharacterListDto> getAll();

    CharacterDto findByName(String name);

    boolean existsById(Long Id);

    //    CharacterDto find
    Optional<CharacterDto> findById(Long id);


    CharacterDto update(Long id, CharacterDto characterDto);

    CharacterDto save(CharacterDto characterDto);

    void delete(Long id);
}
