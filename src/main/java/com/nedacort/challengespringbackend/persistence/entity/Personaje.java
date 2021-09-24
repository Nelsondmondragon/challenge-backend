package com.nedacort.challengespringbackend.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "personajes")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private byte[] imagen;

    private Integer edad;

    private String historia;

    private Integer peso;
    @OneToMany(mappedBy = "personaje", cascade = {CascadeType.ALL})
    private List<PersonajePelicula> personajePeliculas;

    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", imagen=" + Arrays.toString(imagen) +
                ", edad=" + edad +
                ", historia='" + historia + '\'' +
                ", peso=" + peso +
                '}';
    }
}
