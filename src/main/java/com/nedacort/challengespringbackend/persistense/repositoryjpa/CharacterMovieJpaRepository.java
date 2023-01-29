package com.nedacort.challengespringbackend.persistense.repositoryjpa;

import com.nedacort.challengespringbackend.persistense.entities.CharacterMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterMovieJpaRepository extends JpaRepository<CharacterMovie, Long> {


    List<CharacterMovie> findAllByIdCharacter(Long idCharacter);

    boolean existsByIdCharacterAndIdMovie(Long idCharacter, Long idMovie);


}
