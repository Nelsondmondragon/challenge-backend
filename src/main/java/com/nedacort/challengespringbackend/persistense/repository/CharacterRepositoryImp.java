package com.nedacort.challengespringbackend.persistense.repository;

import com.nedacort.challengespringbackend.domain.CharacterDetailsDto;
import com.nedacort.challengespringbackend.domain.CharacterDto;
import com.nedacort.challengespringbackend.domain.CharacterListDto;
import com.nedacort.challengespringbackend.persistense.entities.Character;
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

    @Override
    public List<CharacterListDto> getAll() {
        return characterMapper.toCharacterListDtos(characterJpaRepository.findAll());
    }

    @Override
    public CharacterDto findByName(String name) {
        return characterMapper.toCharacterDto(characterJpaRepository.findByName(name));
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
    public CharacterDto save(CharacterDto characterDto) {
        return characterMapper.toCharacterDto(characterJpaRepository
                .save(characterMapper
                        .toCharacter(characterDto)));
    }

    @Override
    public void delete(Long id) {
        characterJpaRepository.deleteById(id);
    }

}
