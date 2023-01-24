package com.nedacort.challengespringbackend.persistense.repository;

import com.nedacort.challengespringbackend.domain.CharacterDto;
import com.nedacort.challengespringbackend.domain.CharacterListDto;
import com.nedacort.challengespringbackend.persistense.mapper.CharacterListMapper;
import com.nedacort.challengespringbackend.persistense.mapper.CharacterMapper;
import com.nedacort.challengespringbackend.persistense.repositoryjpa.CharacterJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CharacterRepositoryImp implements CharacterRepository {

    @Autowired
    private CharacterJpaRepository characterJpaRepository;

    @Autowired
    private CharacterMapper characterMapper;


    @Autowired
    private CharacterListMapper characterListMapper;


    @Override
    public List<CharacterListDto> getAll() {
        return characterListMapper.toCharacterDtos(characterJpaRepository.findAll());
    }

    @Override
    public Optional<CharacterDto> getById(Integer id) {
        return characterJpaRepository.findById(id).map(character -> characterMapper.toCharacterDto(character));
    }

    @Override
    public CharacterDto save(CharacterDto characterDto) {
        return characterMapper.toCharacterDto(characterJpaRepository
                .save(characterMapper
                        .toCharacter(characterDto)));
    }

    @Override
    public void delete(Integer id) {
        if (characterJpaRepository.existsById(id)) {
            characterJpaRepository.deleteById(id);
        } else {
            System.out.println("Exception");
        }
    }

}
