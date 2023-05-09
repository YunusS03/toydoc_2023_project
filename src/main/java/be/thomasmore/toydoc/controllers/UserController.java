package be.thomasmore.toydoc.controllers;
import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/login")
    public String register(Principal principal, Model model) {
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        model.addAttribute("loginName",loginName);


        //===========CREDENTIALS VOOR DE DEVELOPERS OP DE LOGIN PAGE
        List<AppUser> userList = (List<AppUser>) appUserRepository.findAll();
        AppUser[] userArray = userList.toArray(new AppUser[userList.size()]);
        model.addAttribute("APPUSERS",userArray);


        //===========CREDENTIALS VOOR DE DEVELOPERS OP DE LOGIN PAGE
        // Als er al een gebruiker ingelogd is, ga dan naar home pagina
        if (principal != null) return "redirect:/home";
        // Toon de login pagina
        model.addAttribute("user",new AppUser());
        return "user/login";
    }

    @GetMapping("/signup")
    public String loginReversed(Principal principal, Model model) {
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        model.addAttribute("loginName",loginName);
        //===========CREDENTIALS VOOR DE DEVELOPERS OP DE LOGIN PAGE
        List<AppUser> userList = (List<AppUser>) appUserRepository.findAll();
        AppUser[] userArray = userList.toArray(new AppUser[userList.size()]);
        model.addAttribute("APPUSERS",userArray);
        //===========CREDENTIALS VOOR DE DEVELOPERS OP DE LOGIN PAGE
        // Als er al een gebruiker ingelogd is, ga dan naar home pagina
        if (principal != null) return "redirect:/home";
        // Toon de login pagina
        model.addAttribute("user",new AppUser());
        return "user/signup";
    }



    @PostMapping("/signup-user")
    public String signUp(AppUser user,Principal principal,Model model) {
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        model.addAttribute("loginName",loginName);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        appUserRepository.save(user);
        return "/home";
    }





    // Uitloggen van gebruiker
    @GetMapping("/logout")
    public String logout(Principal principal, Model model) {

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        model.addAttribute("loginName",loginName);
        // Als er geen gebruiker ingelogd is, ga dan naar home pagina
        if (principal == null) return "redirect:/home";
        // Toon home pagina
        return "/home";
    }

}




