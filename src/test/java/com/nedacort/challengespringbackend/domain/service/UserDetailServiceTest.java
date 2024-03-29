package com.nedacort.challengespringbackend.domain.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class UserDetailServiceTest {
//
//    @Mock
//    private EmailSender emailSender;
//
//    @Mock
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Mock
//    private UserDtoRepository userDtoRepository;
//
//    @InjectMocks
//    private UserDetailService userDetailService;
//
//    @Captor
//    private ArgumentCaptor<UserDto> argumentCaptor;
//
//    @Test
//    void load_user_by_username() {
//        Mockito.when(userDtoRepository.getByUsername("nedacort"))
//                .thenReturn(Optional.of(
//                        UserDto.builder()
//                                .id(1)
//                                .username("nedacort")
//                                .email("nelsondmondragon@gmail.com")
//                                .password("121212")
//                                .enable(true)
//                                .locked(false)
//                                .build()
//                ));
//        userDetailService.loadUserByUsername("nedacort");
//        verify(userDtoRepository).getByUsername("nedacort");
//    }
//
//    @Test
//    void save() {
//        UserDto userDto = UserDto.builder()
//                .id(1)
//                .username("nedacort")
//                .email("nelsondmondragon@gmail.com")
//                .password("121212")
//                .enable(true)
//                .locked(false)
//                .build();
//        userDetailService.save(userDto);
//        argumentCaptor = ArgumentCaptor.forClass(UserDto.class);
//        verify(userDtoRepository).save(argumentCaptor.capture());
//
//        Assertions.assertThat(userDto).isEqualTo(argumentCaptor.getValue());
//
//    }
}