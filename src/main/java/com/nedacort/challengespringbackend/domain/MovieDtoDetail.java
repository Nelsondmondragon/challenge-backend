package com.nedacort.challengespringbackend.domain;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovieDtoDetail {
    private Integer id;
    private byte[] image;
    private String tittle;
    private LocalDateTime creationDate;
    private QualificationDto qualificationDto;
    private GenusDto genusDto;
}