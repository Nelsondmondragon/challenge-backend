package com.nedacort.challengespringbackend.persistence.crud;

import com.nedacort.challengespringbackend.persistence.entity.Genero;
import org.springframework.data.repository.CrudRepository;

public interface GeneroCrudRepository extends CrudRepository<Genero, Integer> {
}
