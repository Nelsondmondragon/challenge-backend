package com.nedacort.challengespringbackend.persistence.crud;

import com.nedacort.challengespringbackend.persistence.entity.Personaje;
import com.nedacort.challengespringbackend.persistence.entity.PersonajePelicula;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonajePeliculaCrudRepository extends CrudRepository<PersonajePelicula, Integer> {
    @Query(value = "select personajes.id,personajes.imagen,personajes.nombre,personajes.edad,personajes.peso,"
            + "personajes.historia,personajes_peliculas.id_personaje,personajes_peliculas.id_pelicula,peliculas.id,peliculas.titulo\n"
            + "from personajes\n"
            + "inner join personajes_peliculas\n"
            + "on personajes_peliculas.id_personaje=personajes.id\n"
            + "inner join peliculas\n"
            + "on personajes_peliculas.id_pelicula=peliculas.id\n"
            + "group by personajes.id,personajes_peliculas.id_pelicula,personajes_peliculas.id_personaje,peliculas.id,peliculas.titulo\n"
            + "order by 1 asc", nativeQuery = true)
    Optional<List<PersonajePelicula>> findAllPersonajesAndPeliculas();

    @Query(value = "select personajes.id,personajes.imagen,personajes.nombre,personajes.edad,personajes.peso,"
            + "personajes.historia,personajes_peliculas.id_personaje,personajes_peliculas.id_pelicula,peliculas.id,peliculas.titulo\n"
            + "from personajes\n"
            + "inner join personajes_peliculas\n"
            + "on personajes_peliculas.id_personaje=personajes.id\n"
            + "inner join peliculas\n"
            + "on personajes_peliculas.id_pelicula=peliculas.id\n"
            + "where personajes.nombre ilike %?1%\n"
            + "group by personajes.id,personajes_peliculas.id_pelicula,personajes_peliculas.id_personaje,peliculas.id,peliculas.titulo\n"
            + "order by 1 asc", nativeQuery = true)
    Optional<List<PersonajePelicula>> findAllByNombre(String name);

    @Query(value = "select personajes.id,personajes.imagen,personajes.nombre,personajes.edad,personajes.peso,"
            + "personajes.historia,personajes_peliculas.id_personaje,personajes_peliculas.id_pelicula,peliculas.id,peliculas.titulo\n"
            + "from personajes\n"
            + "inner join personajes_peliculas\n"
            + "on personajes_peliculas.id_personaje=personajes.id\n"
            + "inner join peliculas\n"
            + "on personajes_peliculas.id_pelicula=peliculas.id\n"
            + "where personajes.edad = ?1\n"
            + "group by personajes.id,personajes_peliculas.id_pelicula,personajes_peliculas.id_personaje,peliculas.id,peliculas.titulo\n"
            + "order by 1 asc", nativeQuery = true)
    Optional<List<PersonajePelicula>> findAllByEdad(Integer edad);

    @Query(value = "select personajes.id,personajes.imagen,personajes.nombre,personajes.edad,personajes.peso,"
            + "personajes.historia,personajes_peliculas.id_personaje,personajes_peliculas.id_pelicula,peliculas.id,peliculas.titulo\n"
            + "from personajes\n"
            + "inner join personajes_peliculas\n"
            + "on personajes_peliculas.id_personaje=personajes.id\n"
            + "inner join peliculas\n"
            + "on personajes_peliculas.id_pelicula=peliculas.id\n"
            + "where personajes_peliculas.id_pelicula = ?1\n"
            + "group by personajes.id,personajes_peliculas.id_pelicula,personajes_peliculas.id_personaje,peliculas.id,peliculas.titulo\n"
            + "order by 1 asc", nativeQuery = true)
    Optional<List<PersonajePelicula>> findAllByIdPelicula(Integer id);
}
