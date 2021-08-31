package com.nedacort.challengespringbackend.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "generos")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private byte[] imagen;

    @OneToMany(mappedBy = "genero", cascade = {CascadeType.ALL})
    private List<Pelicula> peliculas;
}
