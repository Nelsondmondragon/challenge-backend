package com.nedacort.challengespringbackend.persistense.repositoryjpa;

import com.nedacort.challengespringbackend.persistense.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieJpaRepository extends JpaRepository<Movie, Long> {


}
