package com.nedacort.challengespringbackend.persistence.mapper;

import com.nedacort.challengespringbackend.domain.MovieDtoLimited;
import com.nedacort.challengespringbackend.persistence.entity.Pelicula;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieDtoLimitedMapper {

    @Mappings({
            @Mapping(source = "imagen", target = "image"),
            @Mapping(source = "titulo", target = "tittle"),
            @Mapping(source = "fechaCreacion", target = "creationDate")
    })
    MovieDtoLimited toMovieDto1(Pelicula pelicula);

    List<MovieDtoLimited> toMovieDto1S(List<Pelicula> peliculas);


}
