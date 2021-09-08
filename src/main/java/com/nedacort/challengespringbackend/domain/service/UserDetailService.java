package com.nedacort.challengespringbackend.domain.service;

import com.nedacort.challengespringbackend.domain.UserDto;
import com.nedacort.challengespringbackend.domain.repository.UserDtoRepository;
import com.nedacort.challengespringbackend.persistence.entity.User;
import com.nedacort.challengespringbackend.persistence.entity.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG =
            "user with username %s not found";


    @Autowired
    private UserDtoRepository userDtoRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userDtoRepository.getByUsername(username).get();
        
        return new User(userDto.getUsername(), userDto.getEmail(), "{noop}" + userDto.getPassword(),
                userDto.getRol(), userDto.getLocked(), userDto.getEnable());
    }
}
