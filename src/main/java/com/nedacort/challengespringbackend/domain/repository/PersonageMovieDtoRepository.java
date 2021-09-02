package com.nedacort.challengespringbackend.domain.repository;

import com.nedacort.challengespringbackend.domain.PersonageDtoDetail;

import java.util.List;
import java.util.Optional;

public interface PersonageMovieDtoRepository {

    Optional<List<PersonageDtoDetail>> findAllPersonajesAndPeliculas();
}
