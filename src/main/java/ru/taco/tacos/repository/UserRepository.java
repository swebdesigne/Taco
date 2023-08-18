package ru.taco.tacos.repository;

import org.springframework.data.repository.CrudRepository;
import ru.taco.tacos.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String name);
}
