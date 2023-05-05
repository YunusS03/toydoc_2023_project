package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Post;
import be.thomasmore.toydoc.model.Role;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import be.thomasmore.toydoc.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {


    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private PostService postService;

    @GetMapping({"/" , "/home"})
    public String home(Model model, Principal principal) {
        // Bepaal de naam van de ingelogde gebruiker
        final String loginName = principal==null ? "NOBODY" : principal.getName();

        // Voeg de naam van de ingelogde gebruiker toe aan het Model
        model.addAttribute("loginName",loginName);

        // Log de naam van de ingelogde gebruiker
        logger.info(loginName);

        // Laad de "home" pagina
        return "home";
    }
    @GetMapping({"/repair"})
    public String repair(Model model, Principal principal) {
        // Bepaal de naam van de ingelogde gebruiker
        final String loginName = principal==null ? "NOBODY" : principal.getName();

        // Voeg de naam van de ingelogde gebruiker toe aan het Model
        model.addAttribute("loginName",loginName);

        // Log de naam van de ingelogde gebruiker
        logger.info(loginName);

        // Laad de "home" pagina
        return "repair";
    }


}
