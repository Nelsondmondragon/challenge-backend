package com.nedacort.challengespringbackend.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MovieListDto {
    private Long idMovie;
    private String image;
    private String title;
    private LocalDateTime createDate;
}
