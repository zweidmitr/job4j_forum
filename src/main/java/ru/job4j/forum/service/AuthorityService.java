package ru.job4j.forum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.repository.data.AuthorityRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorityService {
    private final AuthorityRepository store;

    public Optional<Authority> findBuId(int id) {
        return store.findById(id);
    }
}
