package com.nedacort.challengespringbackend.persistence.crud;

import com.nedacort.challengespringbackend.persistence.entity.Pelicula;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeliculaCrudRepository extends CrudRepository<Pelicula, Integer> {


    @Query(value = "select peliculas.id,peliculas.imagen, peliculas.titulo, peliculas.fecha_creacion,\n" +
            "peliculas.id_genero, peliculas.id_calificacion\n" +
            "from peliculas\n" +
            "where peliculas.titulo ilike %?1%", nativeQuery = true)
    Optional<List<Pelicula>> findByName(String name);

    @Query(value = "select peliculas.id,peliculas.imagen, peliculas.titulo, peliculas.fecha_creacion,\n" +
            "peliculas.id_genero, peliculas.id_calificacion\n" +
            "from peliculas\n" +
            "where peliculas.id_genero = ?1", nativeQuery = true)
    Optional<List<Pelicula>> findByIdGenero(Integer id);

    @Query(value = "select peliculas.id,peliculas.imagen, peliculas.titulo, peliculas.fecha_creacion,\n" +
            "peliculas.id_genero, peliculas.id_calificacion\n" +
            "from peliculas\n" +
            "order by 4 desc", nativeQuery = true)
    Optional<List<Pelicula>> findAllByFechaCreacionDesc();

    @Query(value = "select peliculas.id,peliculas.imagen, peliculas.titulo, peliculas.fecha_creacion,\n" +
            "peliculas.id_genero, peliculas.id_calificacion\n" +
            "from peliculas\n" +
            "order by 4 asc", nativeQuery = true)
    Optional<List<Pelicula>> findAllByFechaCreacionAsc();
}
