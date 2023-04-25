package be.thomasmore.toydoc.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/login")
    public String login(Principal principal, Model model) {
        if (principal != null) return "redirect:/home";
        return "user/login";
    }

    @GetMapping("/logout")
    public String logout(Principal principal, Model model) {
        if (principal == null) return "redirect:/home";
        return "/home";
    }



}




