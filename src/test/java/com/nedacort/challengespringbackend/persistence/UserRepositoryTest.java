package com.nedacort.challengespringbackend.persistence;

import com.nedacort.challengespringbackend.domain.UserDto;
import com.nedacort.challengespringbackend.persistence.crud.UserCrudRepository;
import com.nedacort.challengespringbackend.persistence.entity.User;
import com.nedacort.challengespringbackend.persistence.enums.UserRole;
import com.nedacort.challengespringbackend.persistence.mapper.UserDtoMapper;
import org.aspectj.weaver.patterns.IVerificationRequired;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @Mock
    private UserCrudRepository userCrudRepository;

    @Mock
    private UserDtoMapper userDtoMapper;

    @InjectMocks
    private UserRepository userRepository;

    @Captor
    private ArgumentCaptor<User> argumentCaptor;


    @Test
    void get_user_by_username() {
        userRepository.getByUsername("nedacort");
        Mockito.verify(userCrudRepository).findByUsername("nedacort");
    }

    @Test
    void save() {

        UserDto userDto = UserDto.builder()
                .id(1)
                .username("nedacort")
                .email("nelsondmondragon@gmail.com")
                .password("12222")
                .rol(UserRole.USER)
                .locked(false)
                .enable(true)
                .build();
        Mockito.when(userDtoMapper.toUser(userDto)).thenReturn(
                User.builder()
                        .id(userDto.getId())
                        .username(userDto.getUsername())
                        .email(userDto.getEmail())
                        .password(userDto.getPassword())
                        .rol(userDto.getRol())
                        .locked(userDto.getLocked())
                        .enable(userDto.getEnable())
                        .build()
        );

        userRepository.save(userDto);
        argumentCaptor = ArgumentCaptor.forClass(User.class);

        Mockito.verify(userCrudRepository).save(argumentCaptor.capture());

        Assertions.assertThat(userDto.getId()).isEqualTo(argumentCaptor.getValue().getId());
    }
}