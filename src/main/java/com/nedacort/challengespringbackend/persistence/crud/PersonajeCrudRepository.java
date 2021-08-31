package com.nedacort.challengespringbackend.persistence.crud;

import com.nedacort.challengespringbackend.persistence.entity.Personaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonajeCrudRepository extends CrudRepository<Personaje, Integer> {




    @Query(value = "select personaje.id,personajes.imagen, personajes.nombre, personajes.edad, personajes.peso,\n" +
            "personajes.historia, peliculas.titulo \n" +
            "from personajes\n" +
            "inner join personajes_peliculas\n" +
            "on personajes_peliculas.id_pelicula=personje.id\n" +
            "inner join peliculas\n" +
            "on peliculas.id=personajes_peliculas.id_pelicula\n" +
            "group by personajes.id\n" +
            "order by 3 asc", nativeQuery = true)
    Optional<List<Personaje>> findAllPersonajesAndPeliculas();


}
