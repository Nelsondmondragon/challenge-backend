package com.nedacort.challengespringbackend.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
