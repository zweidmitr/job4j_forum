package ru.job4j.forum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.memory.UserMemory;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMemory store;

    public void save(User user) {
        store.save(user);
    }

    public User findById(int id) {
        return store.findById(id);
    }
}
