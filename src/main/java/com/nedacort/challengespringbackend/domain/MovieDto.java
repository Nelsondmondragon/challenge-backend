package com.nedacort.challengespringbackend.domain;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private Integer id;
    private byte[] image;
    private String tittle;
    private LocalDateTime creationDate;
    private Integer idQualification;
    private Integer idGenus;
}
