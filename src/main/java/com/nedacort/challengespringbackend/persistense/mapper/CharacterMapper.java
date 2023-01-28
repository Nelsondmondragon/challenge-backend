package com.nedacort.challengespringbackend.persistense.mapper;

import com.nedacort.challengespringbackend.domain.CharacterDetailsDto;
import com.nedacort.challengespringbackend.domain.CharacterDto;
import com.nedacort.challengespringbackend.domain.CharacterIdMovieDto;
import com.nedacort.challengespringbackend.domain.CharacterListDto;
import com.nedacort.challengespringbackend.persistense.entities.Character;
import org.mapstruct.*;

import java.util.List;

@Mapper(uses = {MovieMapper.class}, componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CharacterMapper {


    CharacterDto toCharacterDto(Character character);

    List<CharacterDto> toCharacterDtos(List<Character> characters);

    @Mappings({
            @Mapping(target = "idCharacter", ignore = true),
            @Mapping(target = "age", ignore = true),
            @Mapping(target = "peso", ignore = true),
            @Mapping(target = "history", ignore = true),
    })
    List<CharacterListDto> toCharacterListDtos(List<Character> characters);


    CharacterDetailsDto toCharacterDetailsDto(Character character);

    List<CharacterDetailsDto> toCharacterDetailsDtos(List<Character> character);


    @Mapping(target = "idCharacter", ignore = true)
    @Mapping(target = "movies", ignore = true)
    void toUpdateCharacterDto(@MappingTarget Character character, CharacterDto characterDto);

    @InheritInverseConfiguration
    @Mapping(target = "movies", ignore = true)
    Character toCharacter(CharacterDto characterDto);

    @InheritInverseConfiguration
    @Mapping(target = "movies", ignore = true)
    Character toCharacter(CharacterIdMovieDto characterIdMovieDto);
}
