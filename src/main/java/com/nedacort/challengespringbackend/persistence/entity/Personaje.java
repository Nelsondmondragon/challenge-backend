package com.nedacort.challengespringbackend.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "personajes")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private byte[] imagen;

    private Integer edad;

    private String historia;

    @OneToMany(mappedBy = "personaje", cascade = {CascadeType.ALL})
    private List<PersonajePelicula> personajePeliculas;
}
