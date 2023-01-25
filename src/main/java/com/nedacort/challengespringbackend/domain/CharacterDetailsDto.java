package com.nedacort.challengespringbackend.domain;

import lombok.Data;

@Data
public class CharacterDetailsDto {
    private Long id;
    private String name;
    private String image;
    private Integer age;
    private String history;
    private Integer peso;
//    private
}
