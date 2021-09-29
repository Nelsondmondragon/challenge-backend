package com.nedacort.challengespringbackend.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonageDto {
    private Integer id;
    private String name;
    private byte[] image;
    private Integer age;
    private String history;
    private Integer peso;
}
