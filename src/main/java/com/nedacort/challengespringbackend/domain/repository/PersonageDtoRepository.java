package com.nedacort.challengespringbackend.domain.repository;

import com.nedacort.challengespringbackend.domain.PersonageDto;
import com.nedacort.challengespringbackend.persistence.entity.Personaje;

import java.util.List;
import java.util.Optional;

public interface PersonageDtoRepository {


    Optional<PersonageDto> getPersonageById(Integer id);

    PersonageDto save(PersonageDto personageDto);

    void delete(Integer id);
}
