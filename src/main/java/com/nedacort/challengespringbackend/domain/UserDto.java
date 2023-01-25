package com.nedacort.challengespringbackend.domain;

import com.nedacort.challengespringbackend.persistense.enums.UserRole;
import lombok.*;

@Setter
@Getter
public class UserDto {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private UserRole rol;
    private Boolean locked;
    private Boolean enable;
}
