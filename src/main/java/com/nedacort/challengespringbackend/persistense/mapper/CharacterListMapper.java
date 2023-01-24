package com.nedacort.challengespringbackend.persistense.mapper;

import com.nedacort.challengespringbackend.domain.CharacterListDto;
import com.nedacort.challengespringbackend.persistense.entities.Character;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterListMapper {

    CharacterListDto toCharacterDto(Character character);

    List<CharacterListDto> toCharacterDtos(List<Character> characters);

}
