package com.nedacort.challengespringbackend.persistense.repository;

import com.nedacort.challengespringbackend.domain.CharacterDto;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository {

    List<CharacterDto> getAll();

    Optional<CharacterDto> getById(Integer id);

    CharacterDto save(CharacterDto characterDto);

    void delete(Integer id);
}
