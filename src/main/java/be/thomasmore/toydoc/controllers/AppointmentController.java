package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.*;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import be.thomasmore.toydoc.repositories.AppointmentRepository;

import be.thomasmore.toydoc.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    private final EmailService emailService;

    //constructor voor controller blijkbaar
    @Autowired
    public AppointmentController(EmailService emailService) {
        this.emailService = emailService;
    }


    private String mailCurrent;
    private String dateCurrent;
    private String firstNameCurrent;
    private String lastnameCurrent;
    private String secretKey;
    private int hourCurrent;


    private Logger logger = LoggerFactory.getLogger(AppointmentController.class);
    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

//    @Autowired
//    private DoctorRepository doctorRepository;


    @GetMapping("/")
    public String appointment(Model model, Principal principal) {


        String loginName = (String) model.getAttribute("loginName");


//        AppUser appUser = new AppUser("email", "username","password", "firstName", "lastName", 25, "0451256232","adress", "city","2200","country", Role.CLIENT);
        AppUser appUser = appUserRepository.findByUsername(loginName);
        appUserRepository.save(appUser);
        model.addAttribute("loginName", loginName);
        return "appointment";
    }

    @PostMapping("/create-appointment")
    public String createAppointment(Model model, Principal principal,
                                    @RequestParam("firstName") String firstName,
                                    @RequestParam("lastName") String lastName,
                                    @RequestParam("email") String email,
                                    @RequestParam("phone") String phone,
                                    @RequestParam("date") String date,
                                    @RequestParam("hour") int hour) throws ParseException {


        Appointment appointment = new Appointment();
        //momenteel wordt naam van doctor genomen, later moet dit nog aangepast worden dat deze gekozen kan worden.
        AppUser doc = appUserRepository.findByRoleAndUsername(Role.DOCTOR, "dkim");
        logger.info("========= > doctor id is > " + doc.getId() + " name: " + doc.getFirstName());
        if (principal != null) {
            //client bestaat
            AppUser client = appUserRepository.findByUsername(principal.getName());
            //client gevonden
            appointment.createAppointmentUser(stringToDate(date), hour, client, doc);
            mailCurrent = client.getEmail();
            dateCurrent = date;
            hourCurrent = hour;
            firstNameCurrent =client.getFirstName();
            lastnameCurrent = client.getLastName();
            secretKey = appointment.getSecretKey();


        } else {
            AppUser client = new AppUser(firstName, lastName, email, phone);
            appUserRepository.save(client);
//            appointment.createAppointmentNonUser(stringToDate(date), hour, firstName, lastName, phone, email, doc);
            appointment.createAppointmentUser(stringToDate(date), hour, client, doc);
            mailCurrent = email;
            dateCurrent = date;
            hourCurrent = hour;
            firstNameCurrent = firstName;
            lastnameCurrent = lastName;
            secretKey = appointment.getSecretKey();
        }
        appointmentRepository.save(appointment);
        emailService.sendAppointmentConfirmation(mailCurrent, dateCurrent, hourCurrent, firstNameCurrent, lastnameCurrent, secretKey);

        return "redirect:/home";
    }


    @GetMapping("/email/{secretKey}")
    public String manageAppointment(@PathVariable String secretKey, Model model, Principal principal) {


        // Check if the secretKey exists and is valid
        System.out.println("SECRET KEY I GOT : " + secretKey);
        if (isValidSecretKey(secretKey)) {
            Appointment appointment = appointmentRepository.findBySecretKey(secretKey);
            model.addAttribute("appointment", appointment);
            return "manage_appointment";
        } else {
            String errorMessage = "Invalid Key. Please contact support";
            model.addAttribute("errorMessage", errorMessage);
            return "error";
        }
    }


    private boolean isValidSecretKey(String secretKey) {
        Appointment appointment = appointmentRepository.findBySecretKey(secretKey);
        logger.info("SECRET KEY BESTAAT");
        return appointment != null;
    }


    public static Date stringToDate(String dateString) throws ParseException {
        System.out.println("GEKREGEN DATUM =" + dateString);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(dateString);
        System.out.println("GECONVERT NAAR = " + date);
        return date;
    }


    @GetMapping("/confirm/{appointmentId}")
    public String confirmAppointment(@PathVariable("appointmentId") Integer appointmentId, Model model, Principal principal,RedirectAttributes redirectAttributes) {



        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();
            appointment.setConfirmed(true);
            appointmentRepository.save(appointment);
           // ERRORYUNUS //send confirmation missing
            System.out.println("Appointment is confirmed? : " + appointment.getConfirmed());
        }

        redirectAttributes.addAttribute("secretKey", optionalAppointment.get().getSecretKey());
        return "redirect:/appointment/email/{secretKey}";
    }


    @GetMapping("/cancel/{appointmentId}")
    public String cancelAppointment(@PathVariable("appointmentId") Integer appointmentId, Principal principal, Model model) {



        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        AppUser appUser = optionalAppointment.get().getClient();
        appointmentRepository.deleteById(appointmentId);
        model.addAttribute("appUser",appUser);
        emailService.sendAppointmentCancellation(mailCurrent,appUser.getFirstName(),appUser.getLastName());
        //mailcurrent is fout hier!! als de email is veranderd wordt deze nergens opgeslagen dus word de oude mail gebruikt voor de cancelbericht
        //voor nu test purposes is dit OK maar de moment dat 2 achter elkaar doen zullen er foute mails naar foute maileinden gestuurd worden
        return "redirect:/home";
    }







}
