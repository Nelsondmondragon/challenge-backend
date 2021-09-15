package com.nedacort.challengespringbackend.domain.service;

import com.nedacort.challengespringbackend.domain.UserDto;
import com.nedacort.challengespringbackend.domain.repository.UserDtoRepository;
import com.nedacort.challengespringbackend.email.EmailSender;
import com.nedacort.challengespringbackend.persistence.entity.User;
import com.nedacort.challengespringbackend.persistence.entity.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDtoRepository userDtoRepository;

    @Autowired
    private EmailSender emailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userDtoRepository.getByUsername(username).get();
        return new User(userDto.getUsername(), userDto.getEmail(), userDto.getPassword(),
                userDto.getRol(), userDto.getLocked(), userDto.getEnable());
    }

    public UserDto save(UserDto userDto) {
        emailSender.send(userDto.getEmail(), "<h1>welcome</h1>");
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        return userDtoRepository.save(userDto);
    }
}
