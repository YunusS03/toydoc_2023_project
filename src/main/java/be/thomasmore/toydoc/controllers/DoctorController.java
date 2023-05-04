package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Role;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/doctorlist")
    public String doctorList(Model model, Principal principal){
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        model.addAttribute("loginName",loginName);
        List<AppUser> allDoctors = appUserRepository.findByRoleList(Role.DOCTOR);
        model.addAttribute("doctors",allDoctors);
        return "doctorlist";
    }
}
