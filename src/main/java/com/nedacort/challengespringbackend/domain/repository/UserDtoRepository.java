package com.nedacort.challengespringbackend.domain.repository;

import com.nedacort.challengespringbackend.domain.UserDto;

import java.util.Optional;

public interface UserDtoRepository {
    Optional<UserDto> getByUsername(String username);

    UserDto save(UserDto userDto);
}
