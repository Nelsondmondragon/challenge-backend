package com.nedacort.challengespringbackend.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CharacterDetailsDto {
    private Long idCharacter;
    private String name;
    private String image;
    private Integer age;
    private String history;
    private Integer peso;
    private Set<MovieDto> movies;
}
