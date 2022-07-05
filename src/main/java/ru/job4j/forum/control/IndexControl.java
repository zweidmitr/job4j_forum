package ru.job4j.forum.control;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.service.AnswerService;
import ru.job4j.forum.service.PostService;

@Controller
@RequiredArgsConstructor
public class IndexControl {
    private final PostService posts;
    private final AnswerService answers;

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("posts", posts.findAll());
        model.addAttribute("answers", answers.findAll());
        return "index";
    }
}
