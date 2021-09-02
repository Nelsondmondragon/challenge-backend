package com.nedacort.challengespringbackend.persistence.crud;

import com.nedacort.challengespringbackend.persistence.entity.Personaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonajeCrudRepository extends CrudRepository<Personaje, Integer> {


    @Query(value = "select personajes.id,personajes.imagen,personajes.nombre,personajes.edad,personajes.peso,"
            + "personajes.historia,peliculas.titulo\n"
            + "from personajes\n"
            + "inner join personajes_peliculas\n"
            + "on personajes_peliculas.id_personaje=personajes.id\n"
            + "inner join peliculas\n"
            + "on personajes_peliculas.id_pelicula=peliculas.id\n"
            + "group by personajes.id,peliculas.titulo\n"
            + "order by 1 asc", nativeQuery = true)
    Optional<List<Personaje>> findAllPersonajesAndPeliculas();


}
