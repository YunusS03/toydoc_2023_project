package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Role;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class DoctorController {
    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping({"/doctorlist","/doctorlist/{filter}"})
    public String doctorList(Model model, Principal principal,
                             @RequestParam(required = false)String keyword,
                             @RequestParam(required = false)String speciality){




        List<AppUser> allDoctors ;

        if(keyword == null && speciality == null){
            allDoctors = appUserRepository.findByRoleList(Role.DOCTOR);
        }
        else{
            allDoctors = appUserRepository.findByDoctorWithFilter(keyword,Role.DOCTOR,speciality.trim());
        }

        model.addAttribute("keyword",keyword);
        model.addAttribute("speciality",speciality);
        model.addAttribute("doctors",allDoctors);
        return "doctorlist";
    }

    @GetMapping({"/doctordetail/{id}","/doctordetail"})
    public String movieDetails(Model model, @PathVariable(required = false)Integer id){
        if(id==null){
            return "doctordetail";
        }

        Optional<AppUser> optionalDoctor = appUserRepository.findById(id);
        Optional<AppUser> optionalPrev = appUserRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<AppUser> optionalNext = appUserRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalDoctor.isPresent()) {
            AppUser doctor = optionalDoctor.get();
            model.addAttribute("doctor", doctor);
        }

        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", appUserRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", appUserRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "doctordetail";
    }
}
