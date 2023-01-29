package com.nedacort.challengespringbackend.persistense.mapper;

import com.nedacort.challengespringbackend.domain.CharacterMovieDto;
import com.nedacort.challengespringbackend.persistense.entities.CharacterMovie;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMovieMapper {


    CharacterMovieDto toCharacterMovieDto(CharacterMovie characterMovie);

    List<CharacterMovieDto> toCharacterMovieDtos(List<CharacterMovie> characterMovies);

    @InheritInverseConfiguration
    CharacterMovie toCharacterMovie(CharacterMovieDto characterMovieDto);

}
