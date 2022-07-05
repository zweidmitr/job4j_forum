package ru.job4j.forum.repository.data;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String name);

    User findById(int id);
}
