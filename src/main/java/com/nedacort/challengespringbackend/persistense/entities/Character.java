package com.nedacort.challengespringbackend.persistense.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_name")
    private Integer id;
    private String image;
    private String name;
    private Integer age;
    private String history;
    private Integer peso;
    @ManyToMany(mappedBy = "characters", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<Movie> movies;

}
