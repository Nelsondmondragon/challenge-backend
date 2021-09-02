package com.nedacort.challengespringbackend.domain;


import lombok.Data;

@Data
public class PersonageDto {
    private Integer id;
    private String name;
    private byte[] image;
    private Integer age;
    private String history;
    private Integer peso;
}
