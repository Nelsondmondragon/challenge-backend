package com.nedacort.challengespringbackend.persistense.repository;

import com.nedacort.challengespringbackend.domain.MovieDtoLimited;

import java.util.List;

public interface MovieDtoLimitedRepository {


    List<MovieDtoLimited> getAllLimited();
}
