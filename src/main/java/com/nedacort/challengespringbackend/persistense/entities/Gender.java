package com.nedacort.challengespringbackend.persistense.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gender")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gender")
    private Integer idGender;

    private String name;

    private String image;

    @OneToMany(mappedBy = "id_gender", cascade = {CascadeType.ALL})
    private List<Movie> movies;

}