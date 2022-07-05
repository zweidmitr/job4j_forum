package ru.job4j.forum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.data.PostRepository;
import ru.job4j.forum.repository.memory.PostMemory;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository store;

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
        store.delete(post);
    }

    public void update(Post post) {
        store.save(post);
    }
}
