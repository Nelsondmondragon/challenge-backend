package com.nedacort.challengespringbackend.persistense.repository.impl;

import com.nedacort.challengespringbackend.persistense.entities.CharacterMovie;
import com.nedacort.challengespringbackend.persistense.repository.CharacterMovieRepository;
import com.nedacort.challengespringbackend.persistense.repository.CharacterRepository;
import com.nedacort.challengespringbackend.persistense.repositoryjpa.CharacterMovieJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CharacterMovieRepositoryImpl implements CharacterMovieRepository {

    @Autowired
    private CharacterMovieJpaRepository characterMovieJpaRepository;

    @Override
    public CharacterMovie save(Long idCharacter, Long idMovie) {
        CharacterMovie characterMovie = new CharacterMovie();
        characterMovie.setIdCharacter(idCharacter);
        characterMovie.setIdMovie(idMovie);
        return characterMovieJpaRepository.save(characterMovie);
    }
}
