package ru.taco.tacos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import ru.taco.tacos.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String name);

    Optional<User> findByFullname(String username);
}
