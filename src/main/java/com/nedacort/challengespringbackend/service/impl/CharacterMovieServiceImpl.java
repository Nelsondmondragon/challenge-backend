package com.nedacort.challengespringbackend.service.impl;

import com.nedacort.challengespringbackend.domain.CharacterMovieDto;
import com.nedacort.challengespringbackend.persistense.repository.CharacterMovieRepository;
import com.nedacort.challengespringbackend.service.CharacterMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterMovieServiceImpl implements CharacterMovieService {

    @Autowired
    private CharacterMovieRepository characterMovieRepository;


    @Override
    public CharacterMovieDto save(Long idCharacter, Long idMovie) {
        CharacterMovieDto characterMovieDto = new CharacterMovieDto();
        characterMovieDto.setIdCharacter(idCharacter);
        characterMovieDto.setIdMovie(idMovie);
        return characterMovieRepository.save(characterMovieDto);
    }

    @Override
    public List<CharacterMovieDto> findAllByIdCharacter(Long idCharacter) {
        return characterMovieRepository.findAllByIdCharacter(idCharacter);
    }

    @Override
    public CharacterMovieDto findById(Long id) {
        return characterMovieRepository.findById(id).orElseThrow(() -> new RuntimeException("Id characters_movies not exists"));
    }

    @Override
    public boolean existsByIdCharacterAndIdMovie(Long idCharacter, Long idMovie) {
        return characterMovieRepository.findAllByIdCharacterAndIdMovie(idCharacter, idMovie);
    }

    @Override
    public void deleteById(Long id) {
        CharacterMovieDto byId = findById(id);
        characterMovieRepository.deleteById(byId.getId());
    }
}
