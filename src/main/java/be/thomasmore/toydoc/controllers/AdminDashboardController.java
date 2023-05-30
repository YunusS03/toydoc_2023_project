package be.thomasmore.toydoc.controllers;


import be.thomasmore.toydoc.model.*;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import be.thomasmore.toydoc.repositories.AppointmentRepository;
import be.thomasmore.toydoc.repositories.ContactMessageRepository;
import be.thomasmore.toydoc.repositories.PostRepository;
import be.thomasmore.toydoc.service.EmailService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.ZoneId;
import java.util.Date;
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

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    private final EmailService emailService;

    private ContactMessage localMessage;

    @Autowired
    public AdminDashboardController(EmailService emailService){
        this.emailService = emailService;

    }

    @GetMapping("/dashboard")
    public String admin(Model model,HttpServletRequest request) {

        AppUser appUser = (AppUser) request.getAttribute("appUser");
        if (!appUser.getRole().equals(Role.ADMIN)) {
            String errorMessage = "You do not have acces to this page";
            model.addAttribute("errorMessage", errorMessage);
            return "/error";
        }

        List<AppUser> listOfAllDoctors = appUserRepository.findByRoleList(Role.DOCTOR);
        List<AppUser> listOfAllClients = appUserRepository.findByRoleList(Role.CLIENT);
        List<Appointment> listOfAllAppointments = appointmentRepository.findAllBy();
        List<Post> listOfAllPost = postRepository.findAllBy();
        List<ContactMessage> listOfAllMessages = contactMessageRepository.findByIsRead(false);


        model.addAttribute("amountOfDoctors", listOfAllDoctors.size());
        model.addAttribute("amountOfClients", listOfAllClients.size());
        model.addAttribute("amountOfAppointments", listOfAllAppointments.size());
        model.addAttribute("amountOfPosts", listOfAllPost.size());
        model.addAttribute("messages",listOfAllMessages);
        model.addAttribute("amountOfMessage",listOfAllMessages.size());

        return "admin/dashboard";
    }

    @GetMapping({"/searchDoctor", "/searchDoctor/{filter}"})
    public String searchDoctor(Model model, @RequestParam(required = false) String firstName,String lastName) {
        List<AppUser> doctors;
        if (firstName == null && lastName == null) {
            doctors = appUserRepository.findByRoleList(Role.DOCTOR);
        } else {
            doctors = appUserRepository.findByDoctorAdminFilter(firstName,lastName, Role.DOCTOR);

        }
        model.addAttribute("doctors", doctors);
        model.addAttribute("firstName",firstName);
        model.addAttribute("lastName",lastName);

        return "admin/searchDoctor";
    }

    @GetMapping({"/deleteDoctor", "/deleteDoctor/{filter}"})
    public String deleteDoctor(Model model, @RequestParam(required = false) String firstName,String lastName) {
        List<AppUser> doctors;
        if (firstName == null && lastName == null) {
            doctors = appUserRepository.findByRoleList(Role.DOCTOR);
        } else {
            doctors = appUserRepository.findByDoctorAdminFilter(firstName,lastName, Role.DOCTOR);

        }
        model.addAttribute("doctors", doctors);
        model.addAttribute("firstName",firstName);
        model.addAttribute("lastName",lastName);
        return "admin/deleteDoctor";
    }


    @PostMapping("/removeDoctor/{id}")
    public String doctorDelete(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {

        Optional<AppUser> doctor = appUserRepository.findById(id);
        List<Appointment> appointments = appointmentRepository.findByDoctor(doctor.get());
        for (Appointment a : appointments) {
            a.setDoctor(null);
        }

        appointmentRepository.saveAll(appointments);
        appUserRepository.delete(doctor.get());

        return "redirect:/admin/deleteDoctor";
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
        appUserNew.setJob("Doctor");
        appUserRepository.save(appUserNew);

        // Add the appUser object to the model
        model.addAttribute("appUser0", appUserNew);

        return "redirect:/admin/dashboard";
    }

    @GetMapping({"/searchClient", "/searchClient/{filter}"})
    public String searchClient(Model model, @RequestParam(required = false) String firstName,String lastName,Integer id) {
        List<AppUser> clients;
        if (firstName == null && lastName == null && id == null) {
            clients = appUserRepository.findByRoleList(Role.CLIENT);
        } else {
            clients = appUserRepository.findByClientWithFilter(firstName,lastName,Role.CLIENT,id);

        }
        model.addAttribute("clients", clients);
        model.addAttribute("firstName",firstName);
        model.addAttribute("lastName",lastName);
        model.addAttribute("id",id);
        return "admin/searchClient";
    }

    @GetMapping("/addClient")
    public String addClient(Model model) {
        AppUser appUsertest = new AppUser();
        appUsertest.setUsername("appuser" + appUserRepository.count());
        model.addAttribute("appUser0", appUsertest);
        return "admin/addClient";
    }

    @PostMapping("/addClient")
    public String addClientPost(@ModelAttribute("appUser") AppUser appUserNew, Model model) {

        //write me a check if username already exists

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        appUserNew.setPassword(encoder.encode(appUserNew.getPassword()));
        appUserNew.setRole(Role.CLIENT);
        appUserRepository.save(appUserNew);

        // Add the appUser object to the model
        model.addAttribute("appUser0", appUserNew);

        return "redirect:/admin/dashboard";
    }

    @GetMapping({"/deleteClient", "/deleteClient/{filter}"})
    public String deleteClient(Model model, @RequestParam(required = false) String firstName,String lastName,Integer id) {
        List<AppUser> clients;
        if (firstName == null && lastName == null && id==null) {
            clients = appUserRepository.findByRoleList(Role.CLIENT);
        } else {
            clients = appUserRepository.findByClientWithFilter(firstName,lastName,Role.CLIENT,id);

        }
        model.addAttribute("clients", clients);
        model.addAttribute("firstName",firstName);
        model.addAttribute("lastName",lastName);
        model.addAttribute("id",id);
        return "admin/deleteClient";
    }


    @PostMapping("/removeClient/{id}")
    public String clientDelete(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {

        Optional<AppUser> client = appUserRepository.findById(id);
        List<Appointment> appointments = appointmentRepository.findByClient(client.get());
        for (Appointment a : appointments) {
            a.setClient(null);
        }

        appointmentRepository.saveAll(appointments);
        appUserRepository.delete(client.get());

        return "redirect:/admin/deleteClient";
    }

    @GetMapping({"/searchAppointment", "/searchAppointment/{filter}"})
    public String searchAppointment(Model model, @RequestParam(required = false) String doctorName, String clientName, Integer id,String confirm,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        List<Appointment> appointments;



        if (doctorName == null && clientName == null && id == null && confirm==null & date== null  ) {
            appointments = appointmentRepository.findAllBy();
        } else {

            appointments = appointmentRepository.findAppointmentWithFilter(doctorName,clientName,id,
                    ((confirm==null || confirm.equals("All")) ? null : (confirm.equals("Yes") ? true : false)
                    ),date);

        }
        model.addAttribute("appointments", appointments);
        model.addAttribute("doctorName",doctorName);
        model.addAttribute("clientName",clientName);
        model.addAttribute("id",id);
        model.addAttribute("confirm",confirm);
        model.addAttribute("date",date);
        return "admin/searchAppointment";
    }

    @GetMapping({"/confirmAppointment", "/confirmAppointment/{filter}"})
    public String confirmAppointment(Model model, @RequestParam(required = false) String doctorName, String clientName, Integer id,String confirm,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        List<Appointment> appointments;



        if (doctorName == null && clientName == null && id == null && confirm==null & date== null ) {
            appointments = appointmentRepository.findAllBy();
        } else {

            appointments = appointmentRepository.findAppointmentWithFilter(doctorName,clientName,id,
                    ((confirm==null || confirm.equals("All")) ? null : (confirm.equals("Yes") ? true : false)
                    ),date);

        }
        model.addAttribute("appointments", appointments);
        model.addAttribute("doctorName",doctorName);
        model.addAttribute("clientName",clientName);
        model.addAttribute("id",id);
        model.addAttribute("confirm",confirm);
        model.addAttribute("date",date);
        return "admin/confirmAppointment";
    }

    @GetMapping({"/deleteAppointment", "/deleteAppointment/{filter}"})
    public String deleteAppointment(Model model, @RequestParam(required = false) String doctorName, String clientName, Integer id,String confirm,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        List<Appointment> appointments;



        if (doctorName == null && clientName == null && id == null && confirm==null & date== null ) {
            appointments = appointmentRepository.findAllBy();
        } else {

            appointments = appointmentRepository.findAppointmentWithFilter(doctorName,clientName,id,
                    ((confirm==null || confirm.equals("All")) ? null : (confirm.equals("Yes") ? true : false)
                    ),date);

        }
        model.addAttribute("appointments", appointments);
        model.addAttribute("doctorName",doctorName);
        model.addAttribute("clientName",clientName);
        model.addAttribute("id",id);
        model.addAttribute("confirm",confirm);
        model.addAttribute("date",date);
        return "admin/deleteAppointment";
    }

    @GetMapping({"/searchPost", "/searchPost/{filter}"})
    public String searchPost(Model model, @RequestParam(required = false) String title, Integer id,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        List<Post> posts;



        if (title == null && id == null && date== null  ) {
            posts = postRepository.findAllBy();
        } else {
            posts = postRepository.findPostFilter(title,id,date);
        }
        model.addAttribute("posts", posts);
        model.addAttribute("title",title);
        model.addAttribute("id",id);
        model.addAttribute("date",date);
        return "admin/searchPost";
    }

    @GetMapping({"/deletePost", "/deletePost/{filter}"})
    public String deletePost(Model model, @RequestParam(required = false) String title, Integer id,@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        List<Post> posts;



        if (title == null && id == null && date== null  ) {
            posts = postRepository.findAllBy();
        } else {
            posts = postRepository.findPostFilter(title,id,date);
        }
        model.addAttribute("posts", posts);
        model.addAttribute("title",title);
        model.addAttribute("id",id);
        model.addAttribute("date",date);
        return "admin/deletePost";
    }

    @PostMapping("/deletePost/{id}")
    public String deletePost(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {

        Optional<Post> post = postRepository.findById(id);

        postRepository.delete(post.get());

        return "redirect:/admin/deletePost";
    }

    @GetMapping("/addPost")
    public String addPost(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "admin/addPost";
    }

    @PostMapping("/addPost")
    public String addPost(@ModelAttribute("post") Post postNew, Model model) {
       postNew.setDate(Date.from(java.time.LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        postRepository.save(postNew);

        // Add the appUser object to the model
        model.addAttribute("post", postNew);

        return "redirect:/admin/dashboard";
    }

    @GetMapping({"/detailClientMessage/{id}","/detailClientMessage"})
    public String detailMessage(Model model,@PathVariable(required = false)Integer id){
        Optional<ContactMessage> contactMessage = contactMessageRepository.findById(id);

        model.addAttribute("message",contactMessage.get());
        return "/admin/detailClientMessage";
    }

    @PostMapping("/messageReply/{id}")
    public String messageReply(@PathVariable int id,@ModelAttribute ContactMessage contactMessage,@RequestParam String reply) {
        Optional<ContactMessage> existingMessage = contactMessageRepository.findById(id);
        ContactMessage cm = existingMessage.get();
        cm.setRead(true);
        cm.setReplyMessage(reply);
        contactMessageRepository.save(cm);
        emailService.sendReply(cm.getEmail(),cm.getName(),cm.getReplyMessage());
        return "redirect:/admin/dashboard";
    }

    @GetMapping({"/allMessages", "/allMessages/{filter}"})
    public String searchMessage(Model model, @RequestParam(required = false) String senderName, String isRead) {
        List<ContactMessage> allMessages;

        if (senderName == null && isRead == null ) {
            allMessages = contactMessageRepository.findAllBy();
        }
        else {
            allMessages  = contactMessageRepository.findMessageWithFilter(senderName,
                    ((isRead==null || isRead.equals("All")) ? null : (isRead.equals("Read") ? true : false)
                    ));

        }


        model.addAttribute("messages", allMessages);
        model.addAttribute("senderName",senderName);
        model.addAttribute("isRead",isRead);

        return "admin/allMessages";
    }




}
