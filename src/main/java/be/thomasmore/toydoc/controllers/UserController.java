package be.thomasmore.toydoc.controllers;
import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    // Logger voor deze klasse
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    AppUserRepository appUserRepository;

    // Tonen van login pagina
    @GetMapping("/login")
    public String login(Principal principal, Model model) {

        List<AppUser> userList = (List<AppUser>) appUserRepository.findAll();
        AppUser[] userArray = userList.toArray(new AppUser[userList.size()]);

        model.addAttribute("APPUSERS",userArray);
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




