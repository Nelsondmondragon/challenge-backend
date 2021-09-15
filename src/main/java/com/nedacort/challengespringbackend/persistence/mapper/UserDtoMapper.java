package com.nedacort.challengespringbackend.persistence.mapper;

import com.nedacort.challengespringbackend.domain.UserDto;
import com.nedacort.challengespringbackend.persistence.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    UserDto toUserDto(User user);

    @InheritInverseConfiguration
    User toUser(UserDto userDto);
}
