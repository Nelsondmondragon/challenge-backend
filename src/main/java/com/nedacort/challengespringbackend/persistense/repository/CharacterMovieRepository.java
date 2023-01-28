package com.nedacort.challengespringbackend.persistense.repository;

import com.nedacort.challengespringbackend.persistense.entities.CharacterMovie;

import java.util.List;

public interface CharacterMovieRepository {


    CharacterMovie save(Long idCharacter, Long idMovie);


    List<CharacterMovie> findAllByIdCharacter(Long idCharacter);

    void deleteById(Long id);
}

