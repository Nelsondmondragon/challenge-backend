package com.nedacort.challengespringbackend.persistense.repositoryjpa;

import com.nedacort.challengespringbackend.persistense.entities.Gender;
import org.springframework.data.repository.CrudRepository;

public interface GenderJpaRepository extends CrudRepository<Gender, Integer> {
}
