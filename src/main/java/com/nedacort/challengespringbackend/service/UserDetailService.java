package com.nedacort.challengespringbackend.domain.service;


//@Service
public class UserDetailService {}
//implements UserDetailsService {

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Autowired
//    private UserDtoRepository userDtoRepository;
//
//    @Autowired
//    private EmailSender emailSender;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDto userDto = userDtoRepository.getByUsername(username).get();
//        return new User(userDto.getUsername(), userDto.getEmail(), userDto.getPassword(),
//                userDto.getRol(), userDto.getLocked(), userDto.getEnable());
//    }
//
//    public UserDto save(UserDto userDto) {
//        emailSender.send(userDto.getEmail(), "<h1>welcome</h1>");
//        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
//        return userDtoRepository.save(userDto);
//    }
//}
