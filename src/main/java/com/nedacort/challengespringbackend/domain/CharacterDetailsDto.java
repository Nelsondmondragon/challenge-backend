package com.nedacort.challengespringbackend.domain;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDetailsDto {
    private Long idCharacter;
    private String name;
    private String image;
    private Integer age;
    private String history;
    private Integer peso;
    private List<MovieDto> movies;

    public CharacterDetailsDto(Object object) {
        if (object instanceof CharacterDto) {
            CharacterDto characterDto = (CharacterDto) object;
            this.setName(characterDto.getName());
            this.setImage(characterDto.getImage());
            this.setAge(characterDto.getAge());
            this.setHistory(characterDto.getHistory());
            this.setPeso(characterDto.getPeso());
        }

    }
}
