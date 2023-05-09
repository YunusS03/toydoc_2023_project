package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Role;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {


    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping({"/" , "/home"})
    public String home(Model model, Principal principal) {
        // Bepaal de naam van de ingelogde gebruiker
        final String loginName = principal==null ? "NOBODY" : principal.getName();
//        final String firstName =  appUserRepository.findByUsername(loginName).getFirstName();
//        final String lastName =  appUserRepository.findByUsername(loginName).getLastName();

        // Voeg de naam van de ingelogde gebruiker toe aan het Model
        model.addAttribute("loginName",loginName);
//        model.addAttribute("firstName",firstName);
//        model.addAttribute("lastName",lastName);


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
