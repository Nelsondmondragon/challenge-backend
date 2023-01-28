package com.nedacort.challengespringbackend.persistense.repositoryjpa;

import com.nedacort.challengespringbackend.persistense.entities.Character;
import org.hibernate.annotations.NamedQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CharacterJpaRepository extends JpaRepository<Character, Long> {


//    @Query(value = "SELECT distinct(characters.id_character), characters.image,characters.name," +
//            "characters.age,characters.history,characters.peso, movies.id_movie," +
//            "movies.image, movies.title,movies.create_date,movies.qualification " +
//            "FROM characters INNER JOIN characters_movies ON " +
//            "characters_movies.id_character=characters.id_character " +
//            "INNER JOIN movies ON movies.id_movie=characters_movies.id_movie " +
//            "WHERE characters.id_character =?1 ORDER BY characters.ID_CHARACTER asc", nativeQuery = true)
//    Optional<Character> findById(Long id);

    @Query(value = "SELECT * FROM characters WHERE characters.name ILIKE %?1%", nativeQuery = true)
    List<Character> findByName(String name);

    @Query(value = "SELECT * FROM characters WHERE characters.age = ?1", nativeQuery = true)
    List<Character> findByAge(Integer age);


    //    @Query(value = "SELECT * FROM characters INNER JOIN characters_movies ON characters.id_character=characters_movies.id_character WHERE characters_movies.ID_MOVIE = ?1 ORDER BY characters.ID_CHARACTER asc", nativeQuery = true)
    @Query(value = "SELECT characters.id_character, characters.image,characters.name," +
            "characters.age,characters.history,characters.peso, movies.id_movie," +
            "movies.image, movies.title,movies.create_date,movies.qualification " +
            "FROM characters INNER JOIN characters_movies ON " +
            "characters_movies.id_character=characters.id_character " +
            "INNER JOIN movies ON movies.id_movie=characters_movies.id_movie " +
            "WHERE characters.id_character =22 ORDER BY characters.ID_CHARACTER asc", nativeQuery = true)
    List<Character> findByIdMovie(Long idMovie);


}
