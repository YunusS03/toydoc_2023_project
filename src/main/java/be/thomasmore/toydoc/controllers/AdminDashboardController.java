package be.thomasmore.toydoc.controllers;


import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Appointment;
import be.thomasmore.toydoc.model.Post;
import be.thomasmore.toydoc.model.Role;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import be.thomasmore.toydoc.repositories.AppointmentRepository;
import be.thomasmore.toydoc.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

  @Autowired
  private AppUserRepository appUserRepository;

  @Autowired
  private AppointmentRepository appointmentRepository;

  @Autowired
  private PostRepository postRepository;
    @GetMapping({"/dashboard","/dashboard/{keywordDoctor}"})
    public String admin(Model model, @RequestParam(required = false)String keyword){

        List<AppUser> listOfAllDoctors = appUserRepository.findByRoleList(Role.DOCTOR);
        List<AppUser> listOfAllClients = appUserRepository.findByRoleList(Role.CLIENT);
        List<Appointment> listOfAllAppointments = appointmentRepository.findAllBy();
        List<Post> listOfAllPost = postRepository.findAllBy();
        System.out.println("heeey");

        if(keyword!=null){
            System.out.println(keyword);
            System.out.println("alooo");
            List<AppUser> searchedDoctor = appUserRepository.findByFirstNameContainingIgnoreCase(keyword,Role.DOCTOR);
            model.addAttribute("searchedDoctor",searchedDoctor);
        }

        model.addAttribute("amountOfDoctors",listOfAllDoctors.size());
        model.addAttribute("amountOfClients",listOfAllClients.size());
        model.addAttribute("amountOfAppointments",listOfAllAppointments.size());
        model.addAttribute("amountOfPosts",listOfAllPost.size());



        return "admin/dashboard";
    }


}
