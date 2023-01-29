package com.nedacort.challengespringbackend.persistense.repository.impl;

import com.nedacort.challengespringbackend.domain.CharacterMovieDto;
import com.nedacort.challengespringbackend.persistense.mapper.CharacterMovieMapper;
import com.nedacort.challengespringbackend.persistense.repository.CharacterMovieRepository;
import com.nedacort.challengespringbackend.persistense.repositoryjpa.CharacterMovieJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CharacterMovieRepositoryImpl implements CharacterMovieRepository {

    @Autowired
    private CharacterMovieJpaRepository characterMovieJpaRepository;


    @Autowired
    private CharacterMovieMapper characterMovieMapper;

    @Override
    public CharacterMovieDto save(CharacterMovieDto characterMovie) {
        return characterMovieMapper.toCharacterMovieDto(characterMovieJpaRepository
                .save(characterMovieMapper.toCharacterMovie(characterMovie)));
    }

    @Override
    public Optional<CharacterMovieDto> findById(Long id) {
        return characterMovieJpaRepository.findById(id)
                .map(characterMovie -> characterMovieMapper.toCharacterMovieDto(characterMovie));
    }

    @Override
    public List<CharacterMovieDto> findAllByIdCharacter(Long idCharacter) {
        return characterMovieMapper.toCharacterMovieDtos(characterMovieJpaRepository.findAllByIdCharacter(idCharacter));
    }

    @Override
    public boolean findAllByIdCharacterAndIdMovie(Long idCharacter, Long idMovie) {
        return characterMovieJpaRepository
                .existsByIdCharacterAndIdMovie(idCharacter, idMovie);
    }

    @Override
    public void deleteById(Long id) {
        characterMovieJpaRepository.deleteById(id);
    }
}
