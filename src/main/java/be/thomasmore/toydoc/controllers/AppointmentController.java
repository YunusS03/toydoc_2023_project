package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Appointment;
import be.thomasmore.toydoc.model.Doctor;
import be.thomasmore.toydoc.model.Role;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import be.thomasmore.toydoc.repositories.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AppointmentController {


    private Logger logger = LoggerFactory.getLogger(AppointmentController.class);
    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;


    @GetMapping("/appointment")
    public String appointment(Model model, Principal principal) {
        final String loginName = principal==null ? "NOBODY" : principal.getName();
        logger.info(loginName);
        AppUser appUser = new AppUser(0, "test", "test", "test", "test", Role.CLIENT);
        appUserRepository.save(appUser);
        model.addAttribute("loginName",loginName);
        return "appointment";
    }



    @PostMapping("/create-appointment")
    public String createAppointment(@RequestParam("firstName") String firstName,
                                    @RequestParam("lastName") String lastName,
                                    @RequestParam("email") String email,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("date") String date,
                                    @RequestParam("hour") int hour) throws ParseException {



        Appointment appointment = new Appointment();
        Doctor doc = new Doctor();  //momenteel nog geen selectie doctor dus ik genereer een lege doctor voor test doeleinden;
        appointment.createAppointmentNonUser(stringToDate(date),hour,firstName,lastName,phone,email,doc);
        appointmentRepository.save(appointment);


        return "redirect:/test1";
    }




        public static Date stringToDate(String dateString) throws ParseException {
            System.out.println("GEKREGEN DATUM =" + dateString);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dateString);
            System.out.println("GECOVNERT NAAR = "+ date);
            return date;
        }







}
