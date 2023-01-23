package com.nedacort.challengespringbackend.persistence;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {
//
//    @Mock
//    private UserCrudRepository userCrudRepository;
//
//    @Mock
//    private UserDtoMapper userDtoMapper;
//
//    @InjectMocks
//    private UserRepository userRepository;
//
//    @Captor
//    private ArgumentCaptor<User> argumentCaptor;
//
//
//    @Test
//    void get_user_by_username() {
//        userRepository.getByUsername("nedacort");
//        Mockito.verify(userCrudRepository).findByUsername("nedacort");
//    }
//
//    @Test
//    void save() {
//
//        UserDto userDto = UserDto.builder()
//                .id(1)
//                .username("nedacort")
//                .email("nelsondmondragon@gmail.com")
//                .password("12222")
//                .rol(UserRole.USER)
//                .locked(false)
//                .enable(true)
//                .build();
//        Mockito.when(userDtoMapper.toUser(userDto)).thenReturn(
//                User.builder()
//                        .id(userDto.getId())
//                        .username(userDto.getUsername())
//                        .email(userDto.getEmail())
//                        .password(userDto.getPassword())
//                        .rol(userDto.getRol())
//                        .locked(userDto.getLocked())
//                        .enable(userDto.getEnable())
//                        .build()
//        );
//
//        userRepository.save(userDto);
//        argumentCaptor = ArgumentCaptor.forClass(User.class);
//
//        Mockito.verify(userCrudRepository).save(argumentCaptor.capture());
//
//        Assertions.assertThat(userDto.getId()).isEqualTo(argumentCaptor.getValue().getId());
//    }
}