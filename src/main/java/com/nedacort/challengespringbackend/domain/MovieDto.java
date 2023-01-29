package com.nedacort.challengespringbackend.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private Long idMovie;
    private String image;
    private String title;
    private LocalDateTime createDate;
    private Integer qualification;
//    private Integer idGenus;

    public MovieDto(Object object) {
        if (object instanceof MovieDetailsDto) {
            MovieDetailsDto movieDetailsDto = (MovieDetailsDto) object;
            this.setIdMovie(movieDetailsDto.getIdMovie());
            this.setImage(movieDetailsDto.getImage());
            this.setTitle(movieDetailsDto.getTitle());
            this.setCreateDate(movieDetailsDto.getCreateDate());
            this.setQualification(movieDetailsDto.getQualification());
        }
    }
}
