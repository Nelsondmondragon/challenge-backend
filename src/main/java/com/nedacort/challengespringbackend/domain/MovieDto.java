package com.nedacort.challengespringbackend.domain;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovieDto {
    private Integer id;
    private byte[] image;
    private String tittle;
    private LocalDateTime creationDate;
    private Integer idGenus;
    private Integer idQualification;
}
