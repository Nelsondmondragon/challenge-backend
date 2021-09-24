package com.nedacort.challengespringbackend.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "calificaciones")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer calificacion;

    public Calificacion(Integer id, Integer calificacion) {
        this.id = id;
        this.calificacion = calificacion;
    }

    @OneToMany(mappedBy = "calificacion", cascade = {CascadeType.ALL})
    private List<Pelicula> peliculas;
}
