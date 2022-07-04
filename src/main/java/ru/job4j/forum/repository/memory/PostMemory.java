package ru.job4j.forum.repository.memory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostMemory {
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final AtomicInteger id = new AtomicInteger(2);

    private PostMemory() {
        posts.put(0, Post.of("ПРодаю машину ладу", "Суперкар"));
        posts.put(1, Post.of("Срочно куплю пылесос", "лж"));
    }

    public void save(Post post) {
        int newId = id.incrementAndGet();
        post.setId(newId);
        posts.putIfAbsent(newId, post);
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public void delete(int id) {
        Post post = posts.get(id);
        if (post != null) {
            posts.remove(id);
        }
    }

    public void update(Post post) {
        posts.replace(post.getId(), post);
    }
}
