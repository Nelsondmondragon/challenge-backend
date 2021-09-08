package com.nedacort.challengespringbackend.domain;

import com.nedacort.challengespringbackend.persistence.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String email;
    private String password;
    private UserRole rol;
    private Boolean locked;
    private Boolean enable;
}
