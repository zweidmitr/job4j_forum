package ru.job4j.forum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.repository.memory.AuthorityMemory;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AuthorityService {
    private final AuthorityMemory store;

    public Authority findBuId(int id) {
        return store.findById(id);
    }

    public Collection<Authority> findAll() {
        return store.findAll();
    }
}
