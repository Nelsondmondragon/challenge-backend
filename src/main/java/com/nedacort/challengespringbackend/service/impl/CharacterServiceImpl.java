package com.nedacort.challengespringbackend.service.impl;


import com.nedacort.challengespringbackend.domain.CharacterDetailsDto;
import com.nedacort.challengespringbackend.domain.CharacterDto;
import com.nedacort.challengespringbackend.domain.CharacterIdMovieDto;
import com.nedacort.challengespringbackend.domain.CharacterListDto;
import com.nedacort.challengespringbackend.persistense.repository.CharacterRepository;
import com.nedacort.challengespringbackend.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;


    @Override
    public List<CharacterListDto> getAll() {
        return characterRepository.getAll();
    }

    @Override
    public CharacterDetailsDto findById(Long id) {
        Optional<CharacterDetailsDto> byId = characterRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException("Character not exist");
        }

        return byId.get();
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

    public CharacterDto update(Long id, CharacterDto characterDto) {
        return characterRepository.update(id, characterDto);
    }

    @Override
    public CharacterDetailsDto save(CharacterIdMovieDto characterDto) {
//        List<CharacterDto> characterRepo = characterRepository.findByName(characterDto.getName());
//        for (CharacterDto characterDto1 : characterRepo) {
//            if (characterDto1 != null && characterDto1.equals(characterDto)) {
//                throw new RuntimeException("Character exist");
//            }
//        }
        return characterRepository.save(characterDto);
    }

    @Override

    public void delete(Long id) {
        if (!characterRepository.existsById(id)) {
            throw new RuntimeException("Character id not exist");
        }
        characterRepository.delete(id);
    }


//
//    public List<PersonageDtoLimited> getAllNameAndImage() {
//        return personageDtoLimitedRepository.getAllLimited();
//    }
//
//    public Optional<PersonageDto> getPersonageById(Integer id) {
//        return personageDtoRepository.getPersonageById(id);
//    }
//
//
//    public Optional<List<PersonageMovieDto>> findAllByName(String name) {
//        return personageMovieDtoRepository.findAllByName(name);
//    }
//
//    public Optional<List<PersonageMovieDto>> findAllByAge(Integer age) {
//        return personageMovieDtoRepository.findAllByAge(age);
//    }
//
//    public Optional<List<PersonageMovieDto>> findAllByIdMovie(Integer id) {
//        return personageMovieDtoRepository.findAllByIdMovie(id);
//    }


}
