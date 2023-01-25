package com.nedacort.challengespringbackend.persistense.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "genders")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gender")
    private Long idGender;

    private String name;

    private String image;

    @OneToMany(mappedBy = "gender", cascade = {CascadeType.ALL})
    private List<Movie> movies;

}
