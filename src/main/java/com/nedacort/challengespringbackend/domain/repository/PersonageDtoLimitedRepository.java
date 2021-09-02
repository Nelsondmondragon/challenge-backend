package com.nedacort.challengespringbackend.domain.repository;

import com.nedacort.challengespringbackend.domain.PersonageDtoLimited;

import java.util.List;

public interface PersonageDtoLimitedRepository {
    List<PersonageDtoLimited> getAllLimited();
}
