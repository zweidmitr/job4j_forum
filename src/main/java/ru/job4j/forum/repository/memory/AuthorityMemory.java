package ru.job4j.forum.repository.memory;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Authority;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AuthorityMemory {
    private final Map<Integer, Authority> auth = new ConcurrentHashMap<>();

    public AuthorityMemory() {
        auth.put(1, new Authority(1, "ROLE_USER"));
        auth.put(2, new Authority(2, "ROLE_ADMIN"));
    }

    public Authority findById(int id) {
        return auth.get(id);
    }

    public Collection<Authority> findAll() {
        return auth.values();
    }

}
