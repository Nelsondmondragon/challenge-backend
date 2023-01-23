package com.nedacort.challengespringbackend.persistense.entities;

import com.nedacort.challengespringbackend.persistense.enums.UserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String email;
    @Column(name = "passwordd")
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole rol;
    @Column(name = "lockedd")
    private Boolean locked;
    @Column(name = "enablee")
    private Boolean enable;


    public User(String username,
                String email,
                String password,
                UserRole rol,
                Boolean locked,
                Boolean enable) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.locked = locked;
        this.enable = enable;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authorities = new SimpleGrantedAuthority(rol.name());
        return Collections.singleton(authorities);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }
}
