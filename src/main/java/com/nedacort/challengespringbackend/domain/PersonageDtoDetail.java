package com.nedacort.challengespringbackend.domain;

import lombok.Data;

@Data
public class PersonageDtoDetail {
    private Integer id;
    private String name;
    private byte[] image;
    private Integer age;
    private String history;
    private Integer peso;
    private PersonageMovieDto personageMovieDto;
}
