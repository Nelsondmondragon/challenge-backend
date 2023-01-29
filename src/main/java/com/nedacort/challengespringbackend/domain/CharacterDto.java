package com.nedacort.challengespringbackend.domain;


import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDto {
    private Long idCharacter;
    private String name;
    private String image;
    private Integer age;
    private String history;
    private Integer peso;


    public CharacterDto(Object object) {
        if (object instanceof CharacterIdMovieDto) {
            CharacterIdMovieDto characterIdMovieDto = (CharacterIdMovieDto) object;
            this.setName(characterIdMovieDto.getName());
            this.setImage(characterIdMovieDto.getImage());
            this.setAge(characterIdMovieDto.getAge());
            this.setHistory(characterIdMovieDto.getHistory());
            this.setPeso(characterIdMovieDto.getPeso());
        }
    }

}
