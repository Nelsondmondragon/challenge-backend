package com.nedacort.challengespringbackend.persistence.mapper;

import com.nedacort.challengespringbackend.domain.PersonageDtoDetail;
import com.nedacort.challengespringbackend.persistence.entity.Pelicula;
import com.nedacort.challengespringbackend.persistence.entity.Personaje;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PersonageMovieDtoMapper {
    @Mappings({
            @Mapping(source = "personaje.id", target = "id"),
            @Mapping(source = "personaje.nombre", target = "name"),
            @Mapping(source = "personaje.imagen", target = "image"),
            @Mapping(source = "personaje.edad", target = "age"),
            @Mapping(source = "personaje.peso", target = "peso"),
            @Mapping(source = "personaje.historia", target = "history"),
            @Mapping(source = "pelicula.titulo", target = "title")
    })
    PersonageDtoDetail toPersonageMovieDto(Personaje personaje, Pelicula pelicula);


}
