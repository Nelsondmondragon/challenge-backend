package com.nedacort.challengespringbackend.persistense.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@ToString
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
    @ManyToMany(mappedBy = "characters", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Movie> movies;


}
