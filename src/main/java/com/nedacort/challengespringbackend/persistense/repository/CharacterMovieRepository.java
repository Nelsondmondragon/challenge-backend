package com.nedacort.challengespringbackend.persistense.repository;

import com.nedacort.challengespringbackend.domain.CharacterMovieDto;
import com.nedacort.challengespringbackend.persistense.entities.CharacterMovie;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface CharacterMovieRepository {


    CharacterMovieDto save(CharacterMovieDto characterMovie);

    Optional<CharacterMovieDto> findById(Long id);

    List<CharacterMovieDto> findAllByIdCharacter(Long idCharacter);

    boolean findAllByIdCharacterAndIdMovie(Long idCharacter, Long idMovie);


    void deleteById(Long id);
}

