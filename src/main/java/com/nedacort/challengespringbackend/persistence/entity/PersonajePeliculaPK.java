package com.nedacort.challengespringbackend.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class PersonajePeliculaPK implements Serializable {

    @Column(name = "id_pelicula")
    private Integer idPelicula;

    @Column(name = "id_personaje")
    private Integer idPersonaje;
}
