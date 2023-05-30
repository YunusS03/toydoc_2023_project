package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.*;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import be.thomasmore.toydoc.repositories.AppointmentRepository;

import be.thomasmore.toydoc.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Controller
public class CalendarController {

    int count;
    private CalendarService calendarService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping("/test1/{doctorId}")
    public String getCalendar(@PathVariable("doctorId") int id, Model model, Principal principal ,@RequestParam(value = "count", defaultValue = "0") int count) {

        model.addAttribute("count", count);

        //make a list of all id that are doctors
        List<Integer> doctorIds = new ArrayList<>();
        for (AppUser appUser : appUserRepository.findAll()) {
            if (appUser.getRole().equals(Role.DOCTOR)) {
                doctorIds.add(appUser.getId());
            }
        }
        if  (!doctorIds.contains(id)) id = doctorIds.get(0);

        AppUser aud = appUserRepository.findById(id).get();




        if (principal == null) return "redirect:/user/login";
        CalendarService calendarService = new CalendarService();
        List<Day> calendar = count == 0 ?  calendarService.getCurrentWeek() : calendarService.getNextWeek(count);
        final String loginName = principal == null ? null : principal.getName();
        // Voeg de naam van de ingelogde gebruiker toe aan het Model
        model.addAttribute("loginName", loginName);

        List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAllByDoctorId(id);

        for (Appointment ap : appointments) {
            calendarService.setOccupiedOnCalender(ap.getDate(), ap.getTime().getHours());
        }

        Date date1 = new GregorianCalendar(2023, Calendar.MAY, 1).getTime();
        calendarService.setOccupiedOnCalender(date1, 9);



        model.addAttribute("calendar", calendar);
        model.addAttribute("doctor", aud);


        return "test1";
    }


    private int weekCount = 0;

    @PostMapping("/test1/{doctorId}/nextWeek")
    public String nextWeek(@PathVariable("doctorId") int id,Model model, Principal principal, @RequestParam(value = "count", defaultValue = "0") int count) {
        count++;
        System.out.println("========next " + count);
        model.addAttribute("count", count);

        CalendarService calendarService = new CalendarService();
        List<Day> calendar = calendarService.getNextWeek(count);
        List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
        for (Appointment ap : appointments) {
            calendarService.setOccupiedOnCalender(ap.getDate(), ap.getTime().getHours());
        }
        model.addAttribute("calendar", calendar);
        return "redirect:/test1/"+id + "?page=" + count;
    }

    @PostMapping("/test1/{doctorId}/previousWeek")
    public String prevWeek(@PathVariable("doctorId") int id,Model model, Principal principal, @RequestParam(value = "count", defaultValue = "0") int count) {


        count--;

        model.addAttribute("count", count);
        CalendarService calendarService = new CalendarService();
        List<Day> calendar = calendarService.getPreviousWeek(count);
        List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
        for (Appointment ap : appointments) {
            calendarService.setOccupiedOnCalender(ap.getDate(), ap.getTime().getHours());
        }

        model.addAttribute("calendar", calendar);
        return "redirect:/test1/"+id + "?page=" + count;
    }



    @PostMapping("/bookSlot/{id}")
    public String bookSlot(@PathVariable("id") int id,Model model, Principal principal,
                           @RequestParam("date") String date,
                           @RequestParam("hour") int hour){


        //make a list of all id that are doctors
        List<Integer> doctorIds = new ArrayList<>();
        for (AppUser appUser : appUserRepository.findAll()) {
            if (appUser.getRole().equals(Role.DOCTOR)) {
                doctorIds.add(appUser.getId());
            }
        }
        if  (!doctorIds.contains(id)) id = doctorIds.get(0);

        AppUser aud = appUserRepository.findById(id).get();

        if (principal != null) {
            AppUser appUser = appUserRepository.findByUsername(principal.getName());
            model.addAttribute("client", appUser);
        }
        LocalDate selectedDate = LocalDate.parse(date);
        CalendarService calendarService = new CalendarService();
        calendarService.setOccupiedOnCalender(Date.from(selectedDate.atStartOfDay()
                        .atZone(ZoneId.systemDefault()).toInstant()),
                hour);
        model.addAttribute("date", date);
        model.addAttribute("hour", hour);
        model.addAttribute("doctor", aud);
        return "appointment";
    }




}

