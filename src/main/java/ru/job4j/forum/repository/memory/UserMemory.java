package ru.job4j.forum.repository.memory;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class UserMemory {
    private final Map<Integer, User> users = new ConcurrentHashMap<>();
    private final AtomicInteger id = new AtomicInteger(1);

    public UserMemory() {
        users.put(0, User.of("admin", "123"));
    }

    public void save(User user) {
        int newId = id.incrementAndGet();
        users.put(newId, user);
    }

    public User findById(int id) {
        return users.get(id);
    }
}
