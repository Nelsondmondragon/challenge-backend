package com.nedacort.challengespringbackend.persistense.mapper;

import com.nedacort.challengespringbackend.domain.CharacterDto;
import com.nedacort.challengespringbackend.domain.CharacterListDto;
import com.nedacort.challengespringbackend.persistense.entities.Character;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CharacterMapper {
    CharacterDto toCharacterDto(Character character);

    List<CharacterDto> toCharacterDtos(List<Character> characters);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "age", ignore = true),
            @Mapping(target = "peso", ignore = true),
            @Mapping(target = "history", ignore = true),
    })
    List<CharacterListDto> toCharacterListDtos(List<Character> characters);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "movies", ignore = true)
    void toUpdateCharacterDto(@MappingTarget Character character, CharacterDto characterDto);

    @InheritInverseConfiguration
    @Mapping(target = "movies", ignore = true)
    Character toCharacter(CharacterDto characterDto);
}
