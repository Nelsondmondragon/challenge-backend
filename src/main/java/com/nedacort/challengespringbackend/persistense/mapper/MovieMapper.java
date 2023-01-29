package com.nedacort.challengespringbackend.persistense.mapper;

import com.nedacort.challengespringbackend.domain.MovieDetailsDto;
import com.nedacort.challengespringbackend.domain.MovieDto;
import com.nedacort.challengespringbackend.domain.MovieListDto;
import com.nedacort.challengespringbackend.persistense.entities.Movie;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieDto toMovieDto(Movie movie);

    List<MovieDto> toMovieDtos(List<Movie> movies);

    List<MovieListDto> toMovieListDtos(List<Movie> movies);

    MovieDetailsDto toMovieDetailsDto(Movie movie);

    @InheritInverseConfiguration
    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "gender", ignore = true)
    Movie toMovie(MovieDto movieDto);

}
