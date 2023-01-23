package com.nedacort.challengespringbackend.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CharacterDto {
    private Integer id;
    private String name;
    private String image;
    private Integer age;
    private String history;
    private Integer peso;
}
