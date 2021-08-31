package com.nedacort.challengespringbackend.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private byte[] imagen;

    private String titulo;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "id_genero")
    private Integer idGenero;

    @Column(name = "id_calificacion")
    private Integer idCalificacion;


    @ManyToOne
    @JoinColumn(name = "id_genero", insertable = false, updatable = false)
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "id_calificacion", insertable = false, updatable = false)
    private Calificacion calificacion;

    @OneToMany(mappedBy = "pelicula", cascade = {CascadeType.ALL})
    private List<PersonajePelicula> personajePeliculas;
}
