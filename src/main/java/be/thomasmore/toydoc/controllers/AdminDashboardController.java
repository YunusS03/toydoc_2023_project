package be.thomasmore.toydoc.controllers;


import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Appointment;
import be.thomasmore.toydoc.model.Post;
import be.thomasmore.toydoc.model.Role;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import be.thomasmore.toydoc.repositories.AppointmentRepository;
import be.thomasmore.toydoc.repositories.PostRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/dashboard")
    public String admin(Model model) {

        List<AppUser> listOfAllDoctors = appUserRepository.findByRoleList(Role.DOCTOR);
        List<AppUser> listOfAllClients = appUserRepository.findByRoleList(Role.CLIENT);
        List<Appointment> listOfAllAppointments = appointmentRepository.findAllBy();
        List<Post> listOfAllPost = postRepository.findAllBy();
        System.out.println("heeey");


        model.addAttribute("amountOfDoctors", listOfAllDoctors.size());
        model.addAttribute("amountOfClients", listOfAllClients.size());
        model.addAttribute("amountOfAppointments", listOfAllAppointments.size());
        model.addAttribute("amountOfPosts", listOfAllPost.size());

        return "admin/dashboard";
    }

    @GetMapping({"/searchDoctor", "/searchDoctor/{filter}"})
    public String searchDoctor(Model model, @RequestParam(required = false) String keyword) {
        List<AppUser> doctors;
        if (keyword == null) {
            doctors = appUserRepository.findByRoleList(Role.DOCTOR);
        } else {
            doctors = appUserRepository.findByFirstNameContainingIgnoreCase(keyword, Role.DOCTOR);

        }
        model.addAttribute("doctors", doctors);

        return "admin/searchDoctor";
    }

    @GetMapping({"/deleteDoctor", "/deleteDoctor/{filter}"})
    public String deleteDoctor(Model model, @RequestParam(required = false) String keyword) {
        List<AppUser> doctors;
        if (keyword == null) {
            doctors = appUserRepository.findByRoleList(Role.DOCTOR);
        } else {
            doctors = appUserRepository.findByFirstNameContainingIgnoreCase(keyword, Role.DOCTOR);

        }
        model.addAttribute("doctors", doctors);

        return "admin/deleteDoctor";
    }


    @PostMapping("/removeDoctor/{id}")
    public String userDelete(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {

        Optional<AppUser> doctor = appUserRepository.findById(id);
        List<Appointment> appointments = appointmentRepository.findByDoctor(doctor.get());
        for (Appointment a : appointments) {
            a.setDoctor(null);
        }

        appointmentRepository.saveAll(appointments);
        appUserRepository.delete(doctor.get());

        return "redirect:/admin/dashboard";
    }


    @GetMapping("/addDoctor")
    public String addDoctor(Model model) {
        AppUser appUsertest = new AppUser();
        appUsertest.setUsername("appuser" + appUserRepository.count());
        model.addAttribute("appUser0", appUsertest);
        return "admin/addDoctor";
    }

    @PostMapping("/addDoctor")
    public String addDoctorPost(@ModelAttribute("appUser") AppUser appUserNew, Model model) {
        
        //write me a check if username already exists
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        appUserNew.setPassword(encoder.encode(appUserNew.getPassword()));
        appUserNew.setRole(Role.DOCTOR);
        appUserRepository.save(appUserNew);

        // Add the appUser object to the model
        model.addAttribute("appUser0", appUserNew);

        return "redirect:/admin/dashboard";
    }


}
