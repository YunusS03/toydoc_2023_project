package be.thomasmore.toydoc.controllers;
import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Appointment;
import be.thomasmore.toydoc.model.Role;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import be.thomasmore.toydoc.service.EmailService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    EmailService emailService;

    public UserController(EmailService emailService) {
        this.emailService = emailService;
    }

    @Autowired
    AppUserRepository appUserRepository;

    @GetMapping("/login")
    public String register(Principal principal, Model model) {

        //===========CREDENTIALS VOOR DE DEVELOPERS OP DE LOGIN PAGE
        List<AppUser> userList = (List<AppUser>) appUserRepository.findAll();
        AppUser[] userArray = userList.toArray(new AppUser[userList.size()]);
        model.addAttribute("APPUSERS",userArray);
        //===========CREDENTIALS VOOR DE DEVELOPERS OP DE LOGIN PAGE

        // Als er al een gebruiker ingelogd is, ga dan naar home pagina
        if (principal != null) return "redirect:/home";
        // Toon de login pagina
//        model.addAttribute("user",new AppUser());
        return "user/login";
    }

    @GetMapping("/signup")
    public String loginReversed(Principal principal, Model model) {



        // Als er al een gebruiker ingelogd is, ga dan naar home pagina
        if (principal != null) return "redirect:/home";
        // Toon de login pagina
        model.addAttribute("user",new AppUser());
        return "user/signup";
    }



    @PostMapping("/signup-user")
    public String signUp(AppUser user, Principal principal, Model model) {


        AppUser existingUser = appUserRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            // Username already taken, provide appropriate message
            model.addAttribute("errorMessage", "Username already taken");
            return "user/signup"; // Return the signup page to display the error message
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.CLIENT);
        appUserRepository.save(user);

        return "home";
    }





    // Uitloggen van gebruiker
    @GetMapping("/logout")
    public String logout(Principal principal, Model model) {


        // Als er geen gebruiker ingelogd is, ga dan naar home pagina
        if (principal == null) return "redirect:/home";
        // Toon home pagina
        return "/home";
    }



    @GetMapping("/dashboard/{id}")
    public String dashboard(Model model, Principal principal, HttpServletRequest request, @PathVariable(required = false)Integer id){

        AppUser appUser = (AppUser) request.getAttribute("appUser");

        if (appUser.getId() == id){
            return "user/dashboard";
        }
        else{
            String errorMessage = "You do not have acces to this page";
            model.addAttribute("errorMessage", errorMessage);
            return "/error";
        }
    }

    @GetMapping("/dashboard/{id}/profile")
    public String dashboardProfile(Model model,Principal principal,HttpServletRequest request, @PathVariable(required = false)Integer id){

        AppUser appUser = (AppUser) request.getAttribute("appUser");

        if (appUser.getId() == id) {


            final String loginName = principal == null ? null : principal.getName();
            model.addAttribute("loginName", loginName);

            if (loginName != null) {
                model.addAttribute("id", appUserRepository.findByUsername(loginName).getId());
                model.addAttribute("img", appUserRepository.findByUsername(loginName).getProfileImage());
            }

            Optional<AppUser> optionalAppUser = appUserRepository.findById(id);
            if (optionalAppUser.isPresent()) {
                AppUser user = optionalAppUser.get();
                model.addAttribute("user", user);
            }
            return "user/dashboard";
        }
        else{
            String errorMessage = "You do not have acces to this page";
            model.addAttribute("errorMessage", errorMessage);
            return "/error";
        }
    }


    @GetMapping("/forgot-password")
    public String forgotPassword(Principal principal, Model model) {

        String emailUser = "" ;
        model.addAttribute("emailUser", emailUser);


        return "/user/forgotpassword";
    }


    @PostMapping("/forgot-password/send-mail")
    public String forgotPasswordSendMail(@RequestParam("emailUser") String emailUser, Principal principal, Model model) {


        AppUser appUser = appUserRepository.findByEmail(emailUser);
        if (appUser != null){
            logger.info("=========FOUND===========");
            logger.info(appUser.getFirstName() + "  " + appUser.getLastName() + "  " + appUser.getPassword());
            logger.info("Generating Secret One time Use PasswordResetKey");
            appUser.generateSecretPasswordResetKey(appUser.getId().toString());
            appUserRepository.save(appUser);
            logger.info("====================");
            emailService.sendPasswordResetEmail(appUser.getEmail(),appUser.getPasswordResetKey());
        }
        else
        {
            logger.info("USER NOT FOUND");
        }


        return "redirect:/user/forgot-password/sent";
    }



    @GetMapping("/forgot-password/sent")
    public String sendPasswordResetEmail(Model model) {

        String errorMessage = "Email Has Been send";
        model.addAttribute("errorMessage", errorMessage);

        return "/user/forgotpassword";
    }


    @GetMapping("/password-reset/{secretKey}")
    public String manageAppointment(@PathVariable String secretKey, Model model, Principal principal) {



        if (appUserRepository.findByPasswordResetKey(secretKey) != null) {
            AppUser appuser = appUserRepository.findByPasswordResetKey(secretKey);
            model.addAttribute("appuser", appuser);
            String errorMessage = "PASSWORD RESET HTML MOET NOG AANGEMAAKT WORDEN SECRET KEY IS JUST";
            model.addAttribute("errorMessage", errorMessage);
            return "error"; //wijzig nadien de passw reset html pagina is gemaakt
        } else {
            String errorMessage = "Invalid Key. Please contact support";
            model.addAttribute("errorMessage", errorMessage);
            return "error";
        }
    }


}




