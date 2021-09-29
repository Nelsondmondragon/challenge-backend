package com.nedacort.challengespringbackend.persistence.crud;

import com.nedacort.challengespringbackend.persistence.entity.User;
import com.nedacort.challengespringbackend.persistence.enums.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserCrudRepositoryTest {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Test
    void get_user_by_username() {
        User user = User.builder()
                .id(1)
                .username("nedacort")
                .email("nelsondmondragon@gmail.com")
                .password("1234")
                .rol(UserRole.USER)
                .locked(false)
                .enable(true)
                .build();
        assertThat(userCrudRepository.findByUsername("nedacort")).isEqualTo(Optional.of(user));
    }

}