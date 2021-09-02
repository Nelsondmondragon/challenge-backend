package com.nedacort.challengespringbackend.persistence.mapper;

import com.nedacort.challengespringbackend.domain.MovieDto;
import com.nedacort.challengespringbackend.persistence.entity.Pelicula;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MovieDtoMapper {

    @Mappings({
            @Mapping(source = "imagen", target = "image"),
            @Mapping(source = "titulo", target = "tittle"),
            @Mapping(source = "fechaCreacion", target = "creationDate"),
            @Mapping(source = "idGenero", target = "idGenus"),
            @Mapping(source = "idCalificacion", target = "idQualification")
    })
    MovieDto toMovieDto(Pelicula pelicula);


    @InheritInverseConfiguration
    @Mapping(target = "genero", ignore = true)
    @Mapping(target = "calificacion", ignore = true)
    @Mapping(target = "personajePeliculas", ignore = true)
    Pelicula toPelicula(MovieDto movieDto);

}
