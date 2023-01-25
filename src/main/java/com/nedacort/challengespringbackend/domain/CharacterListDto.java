package com.nedacort.challengespringbackend.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CharacterListDto {

    private Integer idCharacter;
    private String name;
    private String image;


}
