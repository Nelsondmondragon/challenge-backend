package com.nedacort.challengespringbackend.persistense.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "characters_movies")
public class CharacterMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_character")
    private Long idCharacter;
    @Column(name = "id_movie")
    private Long idMovie;
}
