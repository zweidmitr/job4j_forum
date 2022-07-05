package ru.job4j.forum.control;


import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.AuthorityService;
import ru.job4j.forum.service.UserService;

@Controller
@Data
public class RegControl {
    private final UserService users;
    private final AuthorityService authorities;
    private final PasswordEncoder encoder;

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user, Model model) {
        User userFromDb = users.findByUsername(user.getUsername());
        if (userFromDb != null) {
            String errorMessage = "User exists!";
            model.addAttribute("errorMessage", errorMessage);
            return "reg";
        }
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorities.findByAuthority("ROLE_USER"));
        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }
}
