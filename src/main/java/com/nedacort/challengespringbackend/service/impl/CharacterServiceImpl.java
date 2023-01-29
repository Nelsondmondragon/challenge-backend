package com.nedacort.challengespringbackend.service.impl;


import com.nedacort.challengespringbackend.domain.*;
import com.nedacort.challengespringbackend.persistense.repository.CharacterRepository;
import com.nedacort.challengespringbackend.service.CharacterMovieService;
import com.nedacort.challengespringbackend.service.CharacterService;
import com.nedacort.challengespringbackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;


    @Autowired
    private MovieService movieService;

    @Autowired
    private CharacterMovieService characterMovieService;

    @Override
    public List<CharacterListDto> getAll() {
        return characterRepository.getAll();
    }

    @Override
    public CharacterDetailsDto findById(Long id) {
        return characterRepository.findById(id).orElseThrow(() -> new RuntimeException("Id character not exists"));
    }

    @Override
    public List<CharacterDto> findByName(String name) {
        return characterRepository.findByName(name);
    }

    @Override
    public List<CharacterDto> findByAge(Integer age) {
        return characterRepository.findByAge(age);
    }

    @Override
    public List<CharacterDetailsDto> findByIdMovie(Long idMovie) {
        return characterRepository.findByIdMovie(idMovie);
    }

    @Override
    public CharacterDto update(Long idCharacter, CharacterIdMovieDto characterIdMovieDto) {
//        System.out.println("ssssssssssssssssss");
        List<Long> idMovies = characterIdMovieDto.getIdMovies();
//        System.out.println(idMovies.size() +" size idMovies");
        List<CharacterMovieDto> allByIdCharacter =
                characterMovieService.findAllByIdCharacter(idCharacter);

//        System.out.println(allByIdCharacter.size() + " size Chara");

        for (CharacterMovieDto characterMovieDto : allByIdCharacter
        ) {
            System.out.println(characterMovieDto + " e");
            if (!idMovies.contains(characterMovieDto.getIdMovie())) {
                characterMovieService.deleteById(characterMovieDto.getId());
            }
        }
        System.out.println("errro");
        for (long id : characterIdMovieDto.getIdMovies()) {
            if (!movieService.existsById(id)) {
                throw new RuntimeException("Id movie not exist");
            }
            if (!characterMovieService.existsByIdCharacterAndIdMovie(idCharacter, id)) {
                characterMovieService.save(idCharacter, id);
            }
        }
        return characterRepository.update(new CharacterDto(characterIdMovieDto));
    }

    @Override
    public CharacterDetailsDto save(CharacterIdMovieDto characterIdMovieDto) {
        List<MovieDto> movieDtos = new ArrayList<>();
        for (long id : characterIdMovieDto.getIdMovies()) {
            if (!movieService.existsById(id)) {
                throw new RuntimeException("Id movie not exist");
            }
            MovieDetailsDto movieDetailsDto = movieService.findById(id);
            movieDtos.add(new MovieDto(movieDetailsDto));
        }
        CharacterDto characterDto = characterRepository.save(new CharacterDto(characterIdMovieDto));
        characterIdMovieDto.getIdMovies().forEach(id -> {
            characterMovieService.save(characterDto.getIdCharacter(), id);
        });
        CharacterDetailsDto characterDetailsDto = new CharacterDetailsDto(characterDto);
        characterDetailsDto.setMovies(movieDtos);
        return characterDetailsDto;
    }

    @Override

    public void delete(Long id) {
        CharacterDetailsDto characterDetailsDto = findById(id);
        characterMovieService.findAllByIdCharacter(characterDetailsDto.getIdCharacter()).forEach(characterMovie -> {
                    characterMovieService.deleteById(characterMovie.getId());
                    characterRepository.deleteById(id);

                }
        );
    }


}
