package com.nedacort.challengespringbackend.persistense.repositoryjpa;

import com.nedacort.challengespringbackend.persistense.entities.CharacterMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterMovieJpaRepository extends JpaRepository<CharacterMovie, Long> {


}
