package com.nedacort.challengespringbackend.persistence.crud;

import com.nedacort.challengespringbackend.persistence.entity.Pelicula;
import org.springframework.data.repository.CrudRepository;

public interface PeliculaCrudRepository extends CrudRepository<Pelicula, Integer> {

}
