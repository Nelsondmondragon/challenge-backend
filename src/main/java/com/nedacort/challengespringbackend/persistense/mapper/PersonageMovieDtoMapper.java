package com.nedacort.challengespringbackend.persistense.mapper;

import com.nedacort.challengespringbackend.domain.PersonageMovieDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

//@Mapper(componentModel = "spring", uses = {MovieDtoMapper.class, PersonageDtoMapper.class})
public interface PersonageMovieDtoMapper {

//    @Mappings({
//
//            @Mapping(source = "pelicula", target = "movieDto"),
//            @Mapping(source = "personaje", target = "personageDto")
//    })
//    PersonageMovieDto toPersonageMovieDto(PersonajePelicula personajePelicula);
//
//    List<PersonageMovieDto> toPersonageMovieDtos(List<PersonajePelicula> personajePeliculas);
//
//    @InheritInverseConfiguration
//    PersonajePelicula toPersonajePelicula(PersonageMovieDto personageMovieDto);
}