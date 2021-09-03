package com.nedacort.challengespringbackend.persistence.mapper;

import com.nedacort.challengespringbackend.domain.MovieDtoDetail;
import com.nedacort.challengespringbackend.persistence.entity.Pelicula;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenusDtoMapper.class, QualificationMapper.class})
public interface MovieDtoDetailsMapper {

    @Mappings({
            @Mapping(source = "imagen", target = "image"),
            @Mapping(source = "titulo", target = "tittle"),
            @Mapping(source = "fechaCreacion", target = "creationDate"),
            @Mapping(source = "calificacion", target = "qualificationDto"),
            @Mapping(source = "genero", target = "genusDto")
    })
    MovieDtoDetail toMovieDto(Pelicula pelicula);

    List<MovieDtoDetail> toMovieDtos(List<Pelicula> peliculas);

    @InheritInverseConfiguration
    @Mapping(target = "idCalificacion", ignore = true)
    @Mapping(target = "idGenero", ignore = true)
    @Mapping(target = "personajePeliculas", ignore = true)
    Pelicula toPelicula(MovieDtoDetail movieDtoDetail);

}
