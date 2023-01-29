package com.nedacort.challengespringbackend.service;

import com.nedacort.challengespringbackend.domain.CharacterMovieDto;
import com.nedacort.challengespringbackend.persistense.entities.CharacterMovie;

import java.util.List;
import java.util.Optional;

public interface CharacterMovieService {


    List<CharacterMovieDto> findAllByIdCharacter(Long idCharacter);


    CharacterMovieDto findById(Long id);

    boolean existsByIdCharacterAndIdMovie(Long idCharacter, Long idMovie);

    CharacterMovieDto save(Long idCharacter, Long idMovie);

    void deleteById(Long id);

}
