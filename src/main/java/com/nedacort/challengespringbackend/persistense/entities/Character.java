package com.nedacort.challengespringbackend.persistense.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_character")
    private Long idCharacter;
    private String image;
    private String name;
    private Integer age;
    private String history;
    private Integer peso;
    @ManyToMany(mappedBy = "characters", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Movie> movies;


}
