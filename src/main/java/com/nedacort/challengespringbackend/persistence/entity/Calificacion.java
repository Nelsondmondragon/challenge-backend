package com.nedacort.challengespringbackend.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "calificaciones")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer calificacion;

    @OneToMany(mappedBy = "calificacion", cascade = {CascadeType.ALL})
    private List<Pelicula> peliculas;
}
