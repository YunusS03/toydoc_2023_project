package be.thomasmore.toydoc.controllers;
import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;
import java.util.List;
import java.util.Optional;


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
        return "user/login";
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

    @GetMapping("/dashboard/{id}")
    public String dashboard(Model model,Principal principal, @PathVariable(required = false)Integer id){
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        model.addAttribute("loginName",loginName);

        if(loginName!="NOBODY"){
            model.addAttribute("id",appUserRepository.findByUsername(loginName).getId());
            model.addAttribute("img",appUserRepository.findByUsername(loginName).getProfileImage());
        }

        Optional<AppUser> optionalAppUser = appUserRepository.findById(id);
        if(optionalAppUser.isPresent()){
            AppUser user =optionalAppUser.get();
            model.addAttribute("user",user);
        }

        return "user/dashboard";
    }

    @GetMapping("/dashboard/{id}/profile")
    public String dashboardProfile(Model model,Principal principal, @PathVariable(required = false)Integer id){
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        model.addAttribute("loginName",loginName);

        if(loginName!="NOBODY"){
            model.addAttribute("id",appUserRepository.findByUsername(loginName).getId());
            model.addAttribute("img",appUserRepository.findByUsername(loginName).getProfileImage());
        }

        Optional<AppUser> optionalAppUser = appUserRepository.findById(id);
        if(optionalAppUser.isPresent()){
            AppUser user =optionalAppUser.get();
            model.addAttribute("user",user);
        }

        return "user/dashboard";
    }
}




