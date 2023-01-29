package com.nedacort.challengespringbackend.service;

import com.nedacort.challengespringbackend.domain.CharacterDetailsDto;
import com.nedacort.challengespringbackend.domain.CharacterDto;
import com.nedacort.challengespringbackend.domain.CharacterIdMovieDto;
import com.nedacort.challengespringbackend.domain.CharacterListDto;

import java.util.List;
import java.util.Optional;


public interface CharacterService {

    List<CharacterListDto> getAll();

    CharacterDetailsDto findById(Long id);

    List<CharacterDto> findByName(String name);

    List<CharacterDto> findByAge(Integer age);

    List<CharacterDetailsDto> findByIdMovie(Long idMovie);

    CharacterDto update(Long id, CharacterIdMovieDto characterDetailsDto);

    CharacterDetailsDto save(CharacterIdMovieDto characterDto);

    void delete(Long id);


}
