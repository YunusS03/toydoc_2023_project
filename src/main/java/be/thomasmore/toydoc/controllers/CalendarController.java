package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.*;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import be.thomasmore.toydoc.repositories.AppointmentRepository;

import be.thomasmore.toydoc.resource.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
public class CalendarController {
    private CalendarService calendarService;

    @Autowired
    private AppointmentRepository appointmentRepository;
//    @Autowired
//    private ClientRepository clientRepository;
    @Autowired
    private AppUserRepository appUserRepository;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping("/test1")
    public String getCalendar(Model model, Principal principal) {
        CalendarService calendarService = new CalendarService();
        List<Day> calendar = calendarService.getCurrentWeek();
        final String loginName = principal == null ? "NOBODY" : principal.getName();
        // Voeg de naam van de ingelogde gebruiker toe aan het Model
        model.addAttribute("loginName", loginName);
        List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
        for (Appointment ap : appointments) {
            calendarService.setOccupiedOnCalender(ap.getDate(), ap.getTime().getHours());
        }

        Date date1 = new GregorianCalendar(2023, Calendar.MAY, 1).getTime();
        calendarService.setOccupiedOnCalender(date1, 9);

        model.addAttribute("calendar", calendar);
        return "test1";
    }


    private int weekCount = 0;

    @PostMapping("/nextWeek")
    public String nextWeek(Model model, Principal principal, @RequestParam(value = "count", defaultValue = "0") int count) {
        final String loginName = principal == null ? "NOBODY" : principal.getName();
        // Voeg de naam van de ingelogde gebruiker toe aan het Model
        model.addAttribute("loginName", loginName);
        count++;
        weekCount = count;
        System.out.println("next" + count);
        model.addAttribute("count", count);
        CalendarService calendarService = new CalendarService();
        List<Day> calendar = calendarService.getNextWeek(weekCount);
        List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
        for (Appointment ap : appointments) {
            calendarService.setOccupiedOnCalender(ap.getDate(), ap.getTime().getHours());
        }

        model.addAttribute("calendar", calendar);
        return "test1";
    }

    @PostMapping("/previousWeek")
    public String prevWeek(Model model, Principal principal, @RequestParam(value = "count", defaultValue = "0") int count) {
        final String loginName = principal == null ? "NOBODY" : principal.getName();
        // Voeg de naam van de ingelogde gebruiker toe aan het Model
        model.addAttribute("loginName", loginName);
        weekCount = count;
        count--;
        System.out.println("prev " + count);
        model.addAttribute("count", count);
        CalendarService calendarService = new CalendarService();
        List<Day> calendar = calendarService.getPreviousWeek(weekCount);
        List<Appointment> appointments = (List<Appointment>) appointmentRepository.findAll();
        for (Appointment ap : appointments) {
            calendarService.setOccupiedOnCalender(ap.getDate(), ap.getTime().getHours());
        }

        model.addAttribute("calendar", calendar);
        return "test1";
    }


    @PostMapping("/bookSlot")
    public String bookSlot(Model model, Principal principal, @RequestParam("date") String date,
                           @RequestParam("hour") int hour) {
        final String loginName = principal == null ? "NOBODY" : principal.getName();
        // Voeg de naam van de ingelogde gebruiker toe aan het Model
        model.addAttribute("loginName", loginName);

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
        return "appointment";
    }


}

