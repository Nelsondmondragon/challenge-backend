package com.nedacort.challengespringbackend.domain;


import lombok.*;

import java.util.Objects;

@Getter
@Setter
public class CharacterDto {
    private Long idCharacter;
    private String name;
    private String image;
    private Integer age;
    private String history;
    private Integer peso;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterDto that = (CharacterDto) o;
        return name.equals(that.name) && age.equals(that.age) && history.equals(that.history) && peso.equals(that.peso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, history, peso);
    }
}
