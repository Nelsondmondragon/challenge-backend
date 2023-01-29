package com.nedacort.challengespringbackend.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class MovieDetailsDto {
    private Long idMovie;
    private String image;
    private String title;
    private LocalDateTime createDate;
    private Integer qualification;
    private List<CharacterDto> characters;
}
