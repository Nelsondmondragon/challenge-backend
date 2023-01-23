package com.nedacort.challengespringbackend.persistense.repository;

//@Repository
public class UserRepository {}

//implements UserDtoRepository {
//
//    @Autowired
//    private UserCrudRepository userCrudRepository;
//
//    @Autowired
//    private UserDtoMapper userDtoMapper;
//
//    @Override
//    public Optional<UserDto> getByUsername(String username) {
//        return userCrudRepository.findByUsername(username)
//                .map(user -> userDtoMapper.toUserDto(user));
//    }
//
//    @Override
//    public UserDto save(UserDto userDto) {
//        return userDtoMapper.toUserDto(userCrudRepository.save(userDtoMapper.toUser(userDto)));
//    }
//}
