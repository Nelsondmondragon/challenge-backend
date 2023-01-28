package com.nedacort.challengespringbackend.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterIdMovieDto {
    private Long idCharacter;
    private String name;
    private String image;
    private Integer age;
    private String history;
    private Integer peso;
    private List<Long> idMovies;
}
