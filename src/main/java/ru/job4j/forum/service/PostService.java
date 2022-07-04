package ru.job4j.forum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.memory.PostMemory;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMemory store;

    public void save(Post post) {
        store.save(post);
    }

    public Collection<Post> findAll() {
        return store.findAll();
    }

    public Post findById(int id) {
        return store.findById(id);
    }

    public void delete(Post post) {
        store.delete(post.getId());
    }

    public void update(Post post) {
        store.update(post);
    }
}
