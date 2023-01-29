package com.nedacort.challengespringbackend.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CharacterMovieDto {
    private Long id;
    private Long idCharacter;
    private Long idMovie;
}
