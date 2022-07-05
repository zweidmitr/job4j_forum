package ru.job4j.forum.control;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Answer;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.AnswerService;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostControl {
    private final PostService posts;
    private final AnswerService answers;
    private final UserService users;

    @GetMapping("/read")
    public String read(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", posts.findById(id));
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "read";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "edit";
    }

    @GetMapping("/update/{postId}")
    public String update(@PathVariable("postId") int id, Model model) {
        model.addAttribute("post", posts.findById(id));
        return "edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post,
                       @ModelAttribute Answer answer) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(users.findByUsername(user.getUsername()));
        if (post.getId() == 0) {
            post.setAnswers(new ArrayList<Answer>());
            posts.save(post);
        } else {
            Post postFromDb = posts.findById(post.getId());
            postFromDb.setDescription(post.getDescription());
            postFromDb.setCreated(new Date(System.currentTimeMillis()));
            postFromDb.setUpdated(new Date(System.currentTimeMillis()));
            posts.update(postFromDb);
        }
        return "redirect:/";
    }

    @PostMapping("/saveAnswer/{postId}")
    public String saveAnswer(@ModelAttribute Answer answer,
                             @PathVariable("postId") int id) {
        Post post = posts.findById(id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        answer.setPost(post);
        answer.setUser(users.findByUsername(user.getUsername()));
        answers.save(answer);
        List<Answer> answerList = post.getAnswers();
        answerList.add(answer);
        post.setAnswers(answerList);
        post.setUpdated(answer.getCreated());
        posts.update(post);

        return "redirect:/read?id=" + id;
    }

}
