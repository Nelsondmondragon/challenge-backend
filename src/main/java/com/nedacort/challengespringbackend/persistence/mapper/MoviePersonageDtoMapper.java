package com.nedacort.challengespringbackend.persistence.mapper;


import com.nedacort.challengespringbackend.domain.MoviePersonageDto;
import com.nedacort.challengespringbackend.domain.PersonageMovieDto;
import com.nedacort.challengespringbackend.persistence.entity.PersonajePelicula;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MovieDtoMapper.class, PersonageDtoMapper.class})
public interface MoviePersonageDtoMapper {
    @Mappings({

            @Mapping(source = "pelicula", target = "movieDto"),
            @Mapping(source = "personaje", target = "personageDto")
    })
    MoviePersonageDto toMoviePersonageDto(PersonajePelicula personajePelicula);

    List<MoviePersonageDto> toMoviePersonageDtos(List<PersonajePelicula> personajePeliculas);

    @InheritInverseConfiguration
    PersonajePelicula toPersonajePelicula(MoviePersonageDto moviePersonageDto);

}
