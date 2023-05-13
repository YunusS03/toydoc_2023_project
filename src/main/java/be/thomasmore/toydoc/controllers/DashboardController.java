package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("profile/{id}")
    public String dashboard(Model model, Principal principal, HttpServletRequest request, @PathVariable(required = false)Integer id){

        AppUser appUser = (AppUser) request.getAttribute("appUser");

        if (appUser.getId() == id){
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


        if(editedAppUser.getProfileImage()==null){
            existingUser.get().setProfileImage("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png");
        }else{
            existingUser.get().setProfileImage(editedAppUser.getProfileImage());
        }


        // only update
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
    public String userDelete( @PathVariable int id, AppUser appUser) {
        appUserRepository.delete(appUser);
        return "redirect:/home";
    }


}
