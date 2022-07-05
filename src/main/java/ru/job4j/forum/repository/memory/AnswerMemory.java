package ru.job4j.forum.repository.memory;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Answer;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AnswerMemory {
    private final Map<Integer, Answer> answers = new ConcurrentHashMap<>();
    private final AtomicInteger id = new AtomicInteger(0);

    public void save(Answer answer) {
        int newId = id.incrementAndGet();
        answers.put(newId, answer);
    }

    public Collection<Answer> findAll() {
        return answers.values();
    }
}
