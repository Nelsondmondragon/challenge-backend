package com.nedacort.challengespringbackend.domain;

 import lombok.Data;

@Data
public class GenusDto {
    private Integer id;
    private String name;
    private byte[] image;
}
