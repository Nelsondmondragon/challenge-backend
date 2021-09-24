package com.nedacort.challengespringbackend.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "imagen")
    private byte[] imagen;

    @Column(name = "titulo")
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

    public Pelicula(Integer id, String titulo, LocalDateTime fechaCreacion, Integer idGenero, Integer idCalificacion) {
        this.id = id;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.idGenero = idGenero;
        this.idCalificacion = idCalificacion;
    }



    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", imagen=" + Arrays.toString(imagen) +
                ", titulo='" + titulo + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", idGenero=" + idGenero +
                ", idCalificacion=" + idCalificacion +
                '}';
    }
}
