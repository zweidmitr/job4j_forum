package ru.job4j.forum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.data.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository store;

    public void save(User user) {
        store.save(user);
    }

    public User findById(int id) {
        return store.findById(id);
    }

    public User findByUsername(String username) {
        return store.findByUsername(username);
    }
}
