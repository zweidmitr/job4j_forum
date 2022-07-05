package ru.job4j.forum.repository.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
}
