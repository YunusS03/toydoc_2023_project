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

    // Logger voor deze klasse
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    // Tonen van login pagina
    @GetMapping("/login")
    public String login(Principal principal, Model model) {
        // Als er al een gebruiker ingelogd is, ga dan naar home pagina
        if (principal != null) return "redirect:/home";
        // Toon de login pagina
        return "user/login";
    }

    // Uitloggen van gebruiker
    @GetMapping("/logout")
    public String logout(Principal principal, Model model) {
        // Als er geen gebruiker ingelogd is, ga dan naar home pagina
        if (principal == null) return "redirect:/home";
        // Toon home pagina
        return "/home";
    }

}




