package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.CalendarService;
import be.thomasmore.toydoc.model.Day;
import be.thomasmore.toydoc.model.TimeSlot;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
public class CalendarController {
    private CalendarService calendarService;



    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping("/test1")
    public String getCalendar(Model model) {
        CalendarService calendarService = new CalendarService();
        List<Day> calendar = calendarService.getCurrentWeek();


        Date date1 = new GregorianCalendar(2023, Calendar.MAY, 1).getTime();
        calendarService.setOccupiedOnCalender(date1,9);


        model.addAttribute("calendar", calendar);
        return "test1";
    }



    private int weekCount = 0;
    @PostMapping("/nextWeek")
    public String nextWeek(Model model, @RequestParam(value = "count", defaultValue = "0") int count) {
        count++;
        weekCount = count;
        System.out.println("next"+ count);
        model.addAttribute("count", count);
        CalendarService calendarService = new CalendarService();
        List<Day> calendar = calendarService.getNextWeek(weekCount);
        model.addAttribute("calendar", calendar);
        return "test1";
    }

    @PostMapping("/previousWeek")
    public String prevWeek(Model model, @RequestParam(value = "count", defaultValue = "0") int count) {
        weekCount = count;
        count--;
        System.out.println("prev "+count);
        model.addAttribute("count", count);
        CalendarService calendarService = new CalendarService();
        List<Day> calendar = calendarService.getPreviousWeek(weekCount);
        model.addAttribute("calendar", calendar);
        return "test1";
    }



    @PostMapping("/bookSlot")
    public String bookSlot(Model model,@RequestParam("date") String date, @RequestParam("hour") int hour) {
        // code to book the time slot for the given date and hour

        System.out.println(date);
        System.out.println(hour);
        model.addAttribute("date",date);
        model.addAttribute("hour",hour);

        return "appointment";
    }





}

