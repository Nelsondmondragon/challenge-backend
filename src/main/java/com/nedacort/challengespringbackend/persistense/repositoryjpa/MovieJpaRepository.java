package com.nedacort.challengespringbackend.persistense.repositoryjpa;

import com.nedacort.challengespringbackend.persistense.entities.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieJpaRepository extends CrudRepository<Movie, Integer> {

//
//    @Query(value = "select peliculas.id,peliculas.imagen, peliculas.titulo, peliculas.fecha_creacion,\n" +
//            "peliculas.id_genero, peliculas.id_calificacion\n" +
//            "from peliculas\n" +
//            "where peliculas.titulo ilike %?1%", nativeQuery = true)
//    Optional<List<Movie>> findByName(String name);
//
//    @Query(value = "select peliculas.id,peliculas.imagen, peliculas.titulo, peliculas.fecha_creacion,\n" +
//            "peliculas.id_genero, peliculas.id_calificacion\n" +
//            "from peliculas\n" +
//            "where peliculas.id_genero = ?1", nativeQuery = true)
//    Optional<List<Movie>> findByIdGenero(Integer id);
//
//    @Query(value = "select peliculas.id,peliculas.imagen, peliculas.titulo, peliculas.fecha_creacion,\n" +
//            "peliculas.id_genero, peliculas.id_calificacion\n" +
//            "from peliculas\n" +
//            "order by 4 desc", nativeQuery = true)
//    Optional<List<Movie>> findAllByFechaCreacionDesc();
//
//    @Query(value = "select peliculas.id,peliculas.imagen, peliculas.titulo, peliculas.fecha_creacion,\n" +
//            "peliculas.id_genero, peliculas.id_calificacion\n" +
//            "from peliculas\n" +
//            "order by 4 asc", nativeQuery = true)
//    Optional<List<Movie>> findAllByFechaCreacionAsc();
}
