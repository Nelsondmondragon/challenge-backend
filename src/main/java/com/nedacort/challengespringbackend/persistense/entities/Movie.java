package com.nedacort.challengespringbackend.persistense.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    private Integer idMovie;

    private String image;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "id_qualification")
    private Integer idQualification;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_gender", insertable = false, updatable = false)
    private Gender gender;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "character_movie",
            joinColumns = @JoinColumn(name = "id_character", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_movie", nullable = false)
    )
    private Set<Character> characters;


}
