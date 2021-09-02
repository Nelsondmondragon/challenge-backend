package com.nedacort.challengespringbackend.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovieDtoLimited {

    private byte[] image;
    private String tittle;
    private LocalDateTime creationDate;
}
