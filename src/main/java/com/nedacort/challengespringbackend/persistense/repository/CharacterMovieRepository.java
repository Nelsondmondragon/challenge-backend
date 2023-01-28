package com.nedacort.challengespringbackend.persistense.repository;

import com.nedacort.challengespringbackend.persistense.entities.CharacterMovie;

public interface CharacterMovieRepository {


    CharacterMovie save(Long idCharacter, Long idMovie);


}
