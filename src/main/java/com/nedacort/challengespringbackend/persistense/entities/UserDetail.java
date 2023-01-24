package com.nedacort.challengespringbackend.persistense.entities;

import com.nedacort.challengespringbackend.persistense.enums.UserRole;
import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.*;
//
//@Data
//public class UserDetail implements UserDetails {
//    private String username;
//    private String email;
//    private String password;
//    private UserRole userRole;
//    private Boolean locked;
//    private Boolean enable;
//
//    public UserDetail(String username,
//                      String email,
//                      String password,
//                      UserRole userRole,
//                      Boolean locked,
//                      Boolean enable) {
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.userRole = userRole;
//        this.locked = locked;
//        this.enable = enable;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        SimpleGrantedAuthority authorities = new SimpleGrantedAuthority(userRole.name());
//        return Collections.singleton(authorities);
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return !locked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enable;
//    }
//}
