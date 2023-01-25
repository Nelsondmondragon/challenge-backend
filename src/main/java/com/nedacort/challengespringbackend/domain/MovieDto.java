package com.nedacort.challengespringbackend.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class MovieDto {
    private Long idMovie;
    private String image;
    private String title;
    private LocalDateTime createDate;
    private Integer qualification;
//    private Integer idGenus;
}
