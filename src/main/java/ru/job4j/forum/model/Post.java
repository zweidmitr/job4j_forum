package ru.job4j.forum.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int id;
    private String name;
    private String description;
    private LocalDateTime date;
    private User user;
    private List<Answer> answers;

    public Post(int id, String name, String description, LocalDateTime date, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.user = user;
    }

    public Post(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static Post of(String name, String description) {
        Post post = new Post();
        post.setName(name);
        post.setDescription(description);
        post.setDate(LocalDateTime.now());
        return post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
