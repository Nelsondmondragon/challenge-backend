package com.nedacort.challengespringbackend.service;


import com.nedacort.challengespringbackend.domain.CharacterDto;
import com.nedacort.challengespringbackend.domain.CharacterListDto;
import com.nedacort.challengespringbackend.persistense.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public List<CharacterListDto> getAll() {
        return characterRepository.getAll();
    }


    public CharacterDto findById(Long id) {
        Optional<CharacterDto> byId = characterRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException("Character not exist");
        }

        return byId.get();
    }

    public CharacterDto update(Long id, CharacterDto characterDto) {
        return characterRepository.update(id, characterDto);
    }

    public CharacterDto save(CharacterDto characterDto) {
        CharacterDto characterRepo = characterRepository.findByName(characterDto.getName());
        if (characterRepo != null && characterRepo.equals(characterDto)) {
            throw new RuntimeException("Character exist");
        }
        return characterRepository.save(characterDto);
    }

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
