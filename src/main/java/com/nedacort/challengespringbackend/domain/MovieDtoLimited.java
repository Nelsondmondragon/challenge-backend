package com.nedacort.challengespringbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDtoLimited {

    private byte[] image;
    private String tittle;
    private LocalDateTime creationDate;
}
