package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Appointment;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import be.thomasmore.toydoc.repositories.AppointmentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/dashboard")



public class DashboardController {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserController userController;

    @GetMapping("profile/{id}")
    public String dashboard(Model model, Principal principal, HttpServletRequest request, @PathVariable(required = false)Integer id){

        AppUser appUser = (AppUser) request.getAttribute("appUser");
        Integer counter = 0;

        if (appUser.getId() == id){
            model.addAttribute("appUser",appUser);
            model.addAttribute("counter",counter);
            return "dashboard/profile";
        }
        else{
            String errorMessage = "You do not have acces to this page";
            model.addAttribute("errorMessage", errorMessage);
            return "/error";
        }

    }

    @PostMapping("/profile/{id}/edit")
    public String profileEdit( @PathVariable int id,@ModelAttribute AppUser editedAppUser) {
        Optional<AppUser> existingUser = appUserRepository.findById(id);


        if(editedAppUser.getProfileImage()==""){
            existingUser.get().setProfileImage("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png");
        }else{
            existingUser.get().setProfileImage(editedAppUser.getProfileImage());
        }


        // only update
//        existingUser.get().setProfileImage(editedAppUser.getProfileImage());
        existingUser.get().setFirstName(editedAppUser.getFirstName());
        existingUser.get().setLastName(editedAppUser.getLastName());
        existingUser.get().setAge(editedAppUser.getAge());
        existingUser.get().setEmail(editedAppUser.getEmail());
        existingUser.get().setPhone(editedAppUser.getPhone());
        existingUser.get().setUsername(editedAppUser.getUsername());
        existingUser.get().setAddress(editedAppUser.getAddress());
        existingUser.get().setPostalCode(editedAppUser.getPostalCode());
        existingUser.get().setCity(editedAppUser.getCity());
        existingUser.get().setCountry(editedAppUser.getCountry());
        appUserRepository.save(existingUser.get());
        return "redirect:/dashboard/profile/"+id;
    }

    @PostMapping("/profile/{id}/delete")
    public String userDelete(@PathVariable int id, @ModelAttribute AppUser appUser, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("isdeleted");
        AppUser appUserPrincipal = (AppUser) request.getAttribute("appUser");


        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.setInvalidateHttpSession(true);
        logoutHandler.logout(request, response, SecurityContextHolder.getContext().getAuthentication());


//        appUserPrincipal.setId(null);
        appUserRepository.delete(appUser);
        return "redirect:/user/logout";
    }

    @GetMapping("/reservationdetail/{id}")
    public String manageAppointment(@PathVariable int id, Model model, Principal principal) {


        // Check if the secretKey exists and is valid
        if (isValidId(id)) {
            Optional<Appointment> appointment = appointmentRepository.findById(id);
            model.addAttribute("appointment", appointment.get());
            return "manage_appointment";
        } else {
            String errorMessage = "Invalid Key. Please contact support";
            model.addAttribute("errorMessage", errorMessage);
            return "error";
        }
    }

    private boolean isValidId(Integer id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        return appointment.get() != null;
    }


}
