package com.nedacort.challengespringbackend.persistence.entity;

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
@Table(name = "generos")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private byte[] imagen;

    public Genero(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @OneToMany(mappedBy = "genero", cascade = {CascadeType.ALL})
    private List<Pelicula> peliculas;

}
