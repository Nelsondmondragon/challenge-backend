package com.nedacort.challengespringbackend.persistense.repository;

import com.nedacort.challengespringbackend.domain.UserDto;

import java.util.Optional;

public interface UserRepository {
    Optional<UserDto> getByUsername(String username);

    UserDto save(UserDto userDto);
}
