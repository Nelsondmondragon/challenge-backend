package com.nedacort.challengespringbackend.persistence;

import com.nedacort.challengespringbackend.domain.UserDto;
import com.nedacort.challengespringbackend.domain.repository.UserDtoRepository;
import com.nedacort.challengespringbackend.persistence.crud.UserCrudRepository;
import com.nedacort.challengespringbackend.persistence.mapper.UserDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository implements UserDtoRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private UserDtoMapper userDtoMapper;

    @Override
    public Optional<UserDto> getByUsername(String username) {
        return userCrudRepository.findByUsername(username)
                .map(user -> userDtoMapper.toUserDto(user));
    }
}
