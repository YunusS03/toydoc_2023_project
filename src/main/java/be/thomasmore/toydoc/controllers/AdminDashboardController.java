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
    public String admin(Model model){

        List<AppUser> listOfAllDoctors = appUserRepository.findByRoleList(Role.DOCTOR);
        List<AppUser> listOfAllClients = appUserRepository.findByRoleList(Role.CLIENT);
        List<Appointment> listOfAllAppointments = appointmentRepository.findAllBy();
        List<Post> listOfAllPost = postRepository.findAllBy();
        System.out.println("heeey");



        model.addAttribute("amountOfDoctors",listOfAllDoctors.size());
        model.addAttribute("amountOfClients",listOfAllClients.size());
        model.addAttribute("amountOfAppointments",listOfAllAppointments.size());
        model.addAttribute("amountOfPosts",listOfAllPost.size());

        return "admin/dashboard";
    }

    @GetMapping({"/searchDoctor","/searchDoctor/{filter}"})
    public String searchDoctor(Model model, @RequestParam(required = false)String keyword) {
        List<AppUser> doctors ;
        if(keyword==null){
            doctors = appUserRepository.findByRoleList(Role.DOCTOR);
        }else{
            doctors = appUserRepository.findByFirstNameContainingIgnoreCase(keyword,Role.DOCTOR);

        }
        model.addAttribute("doctors",doctors);

        return "admin/searchDoctor";
    }

    @GetMapping({"/deleteDoctor","/deleteDoctor/{filter}"})
    public String deleteDoctor(Model model, @RequestParam(required = false)String keyword) {
        List<AppUser> doctors ;
        if(keyword==null){
            doctors = appUserRepository.findByRoleList(Role.DOCTOR);
        }else{
            doctors = appUserRepository.findByFirstNameContainingIgnoreCase(keyword,Role.DOCTOR);

        }
        model.addAttribute("doctors",doctors);

        return "admin/deleteDoctor";
    }



    @PostMapping("/deleteDoctor/{id}")
    public String userDelete(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
//        System.out.println("isdeleted");
//

//        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
//        logoutHandler.setInvalidateHttpSession(true);  //alles wordt geinvalideerd dat de gbr tot dan in de cache heeft
//        logoutHandler.logout(request, response, SecurityContextHolder.getContext().getAuthentication());

        Optional<AppUser> doctor = appUserRepository.findById(id);
        List<Appointment> appointments =  appointmentRepository.findByDoctor(doctor.get());

//        List<Toy> toysClient =  toyRepository.findByClient(appUser);
//        List<Toy> toysAppointment = null;

        System.out.println("==============[][]DELETING USER ALL INFOS[][]=================");

        System.out.println("========[] AppUser Client - TOYS []=========");
//        for (Toy a: toysClient) {
//            System.out.println("Deleting TOY from id "  +  a.getClient().getId() +"wtih name toy : "+ a.getName());
//            toyRepository.deleteById(a.getId());
//        }
//        toyRepository.deleteAll(toysClient);

        System.out.println("==============[] Appoinments []=================");
//        for (Appointment a: appointments
//             ) {
//            System.out.println("Deleting APPOINTMENTS Doctor= "  +  a.getDoctor().getId() +  " client= "  + a.getClient().getId()  +  " Date= "  + a.getDate());
//            toysAppointment = toyRepository.findByAppointment(a);
//        }

//        toyRepository.deleteAll(toysAppointment);

        System.out.println("========[] Appoinments - TOYS []=========");
//        for (Toy toy: toysAppointment) {
//            System.out.println(toy.getId());
//            toyRepository.deleteById(toy.getId());
//        }

//        toyRepository.deleteAll(toysAppointment);

        System.out.println("==============[][]DELETING USER ALL INFOS[][]=================");

        appointmentRepository.deleteAll(appointments);
        appUserRepository.delete(doctor.get());

        return "redirect:admin/dashboard";
    }




    @GetMapping("/addDoctor")
    public String addDoctor(Model model) {
        return "admin/addDoctor";
    }

    @PostMapping("/addDoctor")
    public String addDoctorPost(Model model, AppUser appUser) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        appUser.setPassword(encoder.encode(appUser.getPassword()));
        appUser.setRole(Role.DOCTOR);
        appUserRepository.save(appUser);
        return "admin/dashboard";
    }




}
