package ru.job4j.forum.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    private int id;
    private String text;
    private LocalDateTime date;
    private User user;

    public Answer(int id, String text) {
        this.id = id;
        this.text = text;
    }
}
