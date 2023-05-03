package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.*;
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
import java.util.Optional;

@Controller
public class AppointmentController {


    private Logger logger = LoggerFactory.getLogger(AppointmentController.class);
    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

//    @Autowired
//    private DoctorRepository doctorRepository;


    @GetMapping("/appointment")
    public String appointment(Model model, Principal principal) {
        final String loginName = principal == null ? "NOBODY" : principal.getName();
        logger.info(loginName);
//        AppUser appUser = new AppUser("email", "username","password", "firstName", "lastName", 25, "0451256232","adress", "city","2200","country", Role.CLIENT);
        AppUser appUser = appUserRepository.findByUsername(loginName);
        appUserRepository.save(appUser);
        model.addAttribute("loginName", loginName);
        return "appointment";
    }


    //    @PostMapping("/create-appointment")
//    public String createAppointment(Model model, Principal principal,
//                                    @RequestParam("firstName") String firstName,
//                                    @RequestParam("lastName") String lastName,
//                                    @RequestParam("email") String email,
//                                    @RequestParam("phone") String phone,
//                                    @RequestParam("date") String date,
//                                    @RequestParam("hour") int hour) throws ParseException {
//        final String loginName = principal == null ? "NOBODY" : principal.getName();
//        // Voeg de naam van de ingelogde gebruiker toe aan het Model
//        model.addAttribute("loginName", loginName);
////        Doctor doc = new Doctor();  //momenteel nog geen selectie doctor dus ik genereer een lege doctor voor test doeleinden;
////        doctorRepository.save(doc);
////        Optional<AppUser> optionaldoc = appUserRepository.findByRole(Role.DOCTOR);
////        if (optionaldoc.isPresent()) {
////            optionaldoc.get().getId();
////        }
////        Doctor doc = doctorRepository.findById(1).get();
//        Appointment appointment = new Appointment();
////        appointment.setDoctor(doc);
//        if (principal != null) {
//            AppUser appUser = appUserRepository.findByUsername(principal.getName());
////            Client client = new Client(appUser.getId());
////            appointment.createAppointmentUser(stringToDate(date), hour, client, doc);
////            System.out.println("APPOINTMENT = " + client.getFirstName());
//        } else appointment.createAppointmentNonUser(stringToDate(date), hour, firstName, lastName, phone, email, doc);
//        //appointment.createAppointmentNonUser(stringToDate(date),hour,firstName,lastName,phone,email,doc);
//        appointmentRepository.save(appointment);
//
//        return "redirect:/test1";
//    }
    @PostMapping("/create-appointment")
    public String createAppointment(Model model, Principal principal,
                                    @RequestParam("firstName") String firstName,
                                    @RequestParam("lastName") String lastName,
                                    @RequestParam("email") String email,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("date") String date,
                                    @RequestParam("hour") int hour) throws ParseException {
        final String loginName = principal == null ? "NOBODY" : principal.getName();
        // Voeg de naam van de ingelogde gebruiker toe aan het Model
        model.addAttribute("loginName", loginName);

        Appointment appointment = new Appointment();
        AppUser doc = appUserRepository.findByRole(Role.DOCTOR);
        logger.info("========= > doctor id is > "+doc.getId() + " name: " + doc.getFirstName());
        if (principal != null) {
            AppUser client = appUserRepository.findByUsername(principal.getName());
            logger.info("========= > CLIENT id is > "+client.getId() + " name: " +client.getFirstName());
            appointment.createAppointmentUser(stringToDate(date), hour, client, doc);
        } else {
            appointment.createAppointmentNonUser(stringToDate(date), hour, firstName, lastName, phone, email, doc);
        }
        appointmentRepository.save(appointment);

        return "redirect:/test1";
    }


    public static Date stringToDate(String dateString) throws ParseException {
        System.out.println("GEKREGEN DATUM =" + dateString);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(dateString);
        System.out.println("GECONVERT NAAR = " + date);
        return date;
    }


}
