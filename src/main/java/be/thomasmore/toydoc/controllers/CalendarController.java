package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.CalendarService;
import be.thomasmore.toydoc.model.Day;
import be.thomasmore.toydoc.model.TimeSlot;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("calendar", calendar);

        return "test1";
    }

        @PostMapping("/next-week")
        public String nextWeek(Model model) {
            CalendarService calendarService = new CalendarService();
            List<Day> calendar = calendarService.getNextWeek();
            model.addAttribute("calendar", calendar);
            return "test1";
        }

}

