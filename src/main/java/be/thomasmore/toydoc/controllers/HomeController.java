package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public String home(Model model,HttpServletRequest request) {


//        String loginName = (String) model.getAttribute("loginName");

        AppUser appUser = (AppUser) request.getAttribute("appUser");

model.addAttribute("appUser",appUser);

        // Log de naam van de ingelogde gebruiker

        // Laad de "home" pagina
        return "home";
    }




    @GetMapping({"/repair"})
    public String repair(Model model) {
//        AppUser appUser = (AppUser) request.getAttribute("appUser");

//          //try only when logged in
//        System.out.println("===================LOGGED IN USER DETAILS=====================");
//        System.out.println("appUser: " + appUser.getEmail());
//        System.out.println("firstName: " + appUser.getFirstName());
//        System.out.println("loginname: " + appUser.getUsername());
//        System.out.println("passw: " + appUser.getPassword());
//        System.out.println("loginname: " + appUser.getUsername());
//        System.out.println("==================LOGGED IN USER DETAILS======================");
//


        // Laad de "home" pagina
        return "repair";
    }




    @GetMapping("/about")
    public String about(Model model) {
//        System.out.println(model.getAttribute("loginName"));
        return "about";
    }

    @GetMapping({"/contact"})
    public String contact(Model model) {
        return "contact";
    }


}
