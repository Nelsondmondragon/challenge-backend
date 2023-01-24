package com.nedacort.challengespringbackend.persistense.mapper;

import com.nedacort.challengespringbackend.domain.MovieDto;
import com.nedacort.challengespringbackend.persistense.entities.Movie;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieDtoMapper {

    MovieDto toMovieDto(Movie movie);
    List<MovieDto> toMovieDtos(List<Movie> movies);
    @InheritInverseConfiguration
    Movie toMovie(MovieDto movieDto);

}
