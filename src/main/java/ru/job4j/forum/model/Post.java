package ru.job4j.forum.model;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date(System.currentTimeMillis());
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated = new Date(System.currentTimeMillis());
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private List<Answer> answers;

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
