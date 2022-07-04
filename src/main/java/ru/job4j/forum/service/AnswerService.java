package ru.job4j.forum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Answer;
import ru.job4j.forum.repository.memory.AnswerMemory;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerMemory store;

    public void save(Answer answer) {
        store.save(answer);
    }

    public Collection<Answer> findAll() {
        return store.findAll();
    }
}
