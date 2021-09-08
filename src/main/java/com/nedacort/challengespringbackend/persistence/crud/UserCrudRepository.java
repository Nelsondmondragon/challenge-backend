package com.nedacort.challengespringbackend.persistence.crud;

import com.nedacort.challengespringbackend.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCrudRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
