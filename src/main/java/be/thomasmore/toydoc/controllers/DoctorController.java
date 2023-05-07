package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Role;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping({"/doctorlist","/doctorlist/{filter}"})
    public String doctorList(Model model, Principal principal,
                             @RequestParam(required = false)String keyword,
                             @RequestParam(required = false)String speciality){

        final String loginName = principal==null ? "NOBODY" : principal.getName();
        model.addAttribute("loginName",loginName);

        List<AppUser> allDoctors ;

        if(keyword == null && speciality == null){
            allDoctors = appUserRepository.findByRoleList(Role.DOCTOR);
        }else{
            allDoctors = appUserRepository.findByDoctorWithFilter(Role.DOCTOR,keyword,speciality.trim());
        }

        System.out.println(speciality);

        model.addAttribute("keyword",keyword);
        model.addAttribute("speciality",speciality);
        model.addAttribute("doctors",allDoctors);
        return "doctorlist";
    }
}
