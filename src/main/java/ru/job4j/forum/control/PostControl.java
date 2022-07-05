package ru.job4j.forum.control;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Answer;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.AnswerService;
import ru.job4j.forum.service.PostService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostControl {
    private final PostService posts;
    private final AnswerService answers;

    @GetMapping("/read")
    public String read(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", posts.findById(id));
        return "read";
    }

    @GetMapping("/create")
    public String create(Model model) {
        return "edit";
    }

    @GetMapping("/update/{postId}")
    public String update(@PathVariable("postId") int id, Model model) {
        model.addAttribute("post", posts.findById(id));
        return "edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        if (post.getId() == 0) {
            post.setDate(LocalDateTime.now());
            post.setAnswers(new ArrayList<Answer>());
            posts.save(post);
        } else {
            post.setDate(LocalDateTime.now());
            posts.update(post);
        }
        return "redirect:/";
    }

    @PostMapping("/saveAnswer/{postId}")
    public String saveAnswer(@ModelAttribute Answer answer,
                             @PathVariable("postId") int id) {
        answer.setDate(LocalDateTime.now());
        answers.save(answer);
        Post post = posts.findById(id);
        List<Answer> answerList = post.getAnswers();
        answerList.add(answer);
        post.setAnswers(answerList);
        posts.update(post);

        return "redirect:/read?id=" + id;
    }

}
