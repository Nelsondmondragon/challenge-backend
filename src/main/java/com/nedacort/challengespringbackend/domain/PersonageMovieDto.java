package com.nedacort.challengespringbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonageMovieDto {

    private CharacterDto characterDto;
    private MovieDto movieDto;

}
