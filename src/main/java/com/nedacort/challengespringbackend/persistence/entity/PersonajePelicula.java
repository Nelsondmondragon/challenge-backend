package com.nedacort.challengespringbackend.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "personajes_peliculas")
public class PersonajePelicula {

    @EmbeddedId
    private PersonajePeliculaPK id;

    @ManyToOne
    @JoinColumn(name = "id_personaje", insertable = false, updatable = false)
    private Personaje personaje;

    @ManyToOne
    @JoinColumn(name = "id_pelicula", insertable = false, updatable = false)
    private Pelicula pelicula;
}
