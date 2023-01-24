package com.nedacort.challengespringbackend.persistense.mapper;

import com.nedacort.challengespringbackend.domain.CharacterDto;
import com.nedacort.challengespringbackend.persistense.entities.Character;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    CharacterDto toCharacterDto(Character character);
    List<CharacterDto> toCharacterDtos(List<Character> characters);

    @InheritInverseConfiguration
    Character toCharacter(CharacterDto characterDto);
}
