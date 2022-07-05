package ru.job4j.forum.repository.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
    @Query("select distinct p from Post p "
            + "left join fetch p.answers a "
            + "order by p.id")
    List<Post> findAll();

    @Query("select distinct  p from Post p "
            + "left join fetch p.answers a "
            + "where p.id = :id")
    Post findById(int id);
}
