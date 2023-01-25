package com.nedacort.challengespringbackend.persistense.repositoryjpa;

import com.nedacort.challengespringbackend.persistense.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterJpaRepository extends JpaRepository<Character, Long> {

    Character findByName(String name);

}
