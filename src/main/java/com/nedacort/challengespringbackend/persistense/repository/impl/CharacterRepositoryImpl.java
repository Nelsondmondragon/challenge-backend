package com.nedacort.challengespringbackend.persistense.repository.impl;

import com.nedacort.challengespringbackend.domain.*;
import com.nedacort.challengespringbackend.persistense.entities.Character;
import com.nedacort.challengespringbackend.persistense.mapper.CharacterMapper;
import com.nedacort.challengespringbackend.persistense.repository.CharacterMovieRepository;
import com.nedacort.challengespringbackend.persistense.repository.CharacterRepository;
import com.nedacort.challengespringbackend.persistense.repository.MovieRepository;
import com.nedacort.challengespringbackend.persistense.repositoryjpa.CharacterJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

    @Autowired
    private CharacterJpaRepository characterJpaRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CharacterMovieRepository characterMovieRepository;
    @Autowired
    private CharacterMapper characterMapper;

    @Override
    public List<CharacterListDto> getAll() {
        return characterMapper.toCharacterListDtos(characterJpaRepository.findAll());
    }

    @Override
    public List<CharacterDto> findByName(String name) {
        return characterMapper.toCharacterDtos(characterJpaRepository.findByName(name));

    }

    @Override
    public List<CharacterDto> findByAge(Integer age) {
        return characterMapper.toCharacterDtos(characterJpaRepository.findByAge(age));
    }

    @Override
    public List<CharacterDetailsDto> findByIdMovie(Long idMovie) {

        for (Character character : characterJpaRepository.findByIdMovie(idMovie)
        ) {
            System.out.println("ssss " + character.getMovies().size());

        }

        return characterMapper.toCharacterDetailsDtos(characterJpaRepository.findByIdMovie(idMovie));
    }


    @Override
    public boolean existsById(Long id) {
        return characterJpaRepository.existsById(id);
    }

    @Override
    public Optional<CharacterDetailsDto> findById(Long id) {
        return characterJpaRepository.findById(id).map(character -> characterMapper.toCharacterDetailsDto(character))
                ;
    }

    @Override
    public CharacterDto update(Long id, CharacterDto characterDto) {
        Optional<Character> characterOptional = characterJpaRepository.findById(id);
        if (characterOptional.isEmpty()) {
            throw new RuntimeException("Not exist character");
        }
        characterMapper.toUpdateCharacterDto(characterOptional.get(), characterDto);
        return characterMapper.toCharacterDto(characterJpaRepository.save(characterOptional.get()));

    }

    @Override
    public CharacterDetailsDto save(CharacterIdMovieDto characterIdMovieDto) {
        List<MovieDto> movieDtos = new ArrayList<>();
        for (long id : characterIdMovieDto.getIdMovies()) {
            if (!movieRepository.existsById(id)) {
                throw new RuntimeException("Id movie not exist");
            }
            movieRepository.findById(id).ifPresent(movieDtos::add);
        }
        CharacterDetailsDto characterDetailsDto = characterMapper.toCharacterDetailsDto(
                characterJpaRepository
                        .save(characterMapper.toCharacter(characterIdMovieDto)));
        characterIdMovieDto.getIdMovies().forEach(id -> {
            characterMovieRepository.save(characterDetailsDto.getIdCharacter(), id);
        });
        characterDetailsDto.setMovies(movieDtos);
        return characterDetailsDto;
    }

    @Override
    public void deleteById(Long id) {
        characterJpaRepository.findById(id).ifPresent(character -> {
                    characterMovieRepository.findAllByIdCharacter(character.getIdCharacter()).forEach(characterMovie -> {
                        characterMovieRepository.deleteById(characterMovie.getId());
                    });
                }
        );
        characterJpaRepository.deleteById(id);

    }

}
