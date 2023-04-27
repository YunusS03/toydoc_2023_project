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
public class AppointmentController {


    private Logger logger = LoggerFactory.getLogger(AppointmentController.class);
    @Autowired
    private AppUserRepository appUserRepository;
    @GetMapping("/appointment")
    public String appointment(Model model, Principal principal) {
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info(loginName);
        AppUser appUser = new AppUser(0, "test", "test", "test", "test", Role.CLIENT);
        appUserRepository.save(appUser);
        model.addAttribute("loginName",loginName);
        return "appointment";
    }



}
