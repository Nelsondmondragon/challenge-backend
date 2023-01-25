package com.nedacort.challengespringbackend.persistense.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    private Long idMovie;

    private String image;

    private String title;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    private Integer qualification;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gender", insertable = false, updatable = false)
    private Gender gender;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "characters_movies",
            joinColumns = @JoinColumn(name = "id_character", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_movie", nullable = false)
    )
    @JsonManagedReference
    private Set<Character> characters;


}
