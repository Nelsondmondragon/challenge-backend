package com.nedacort.challengespringbackend.domain;

import com.nedacort.challengespringbackend.persistence.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private UserRole rol;
    private Boolean locked;
    private Boolean enable;
}
