package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.CalendarService;
import be.thomasmore.toydoc.model.Day;
import be.thomasmore.toydoc.model.TimeSlot;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import java.time.LocalDate;
//import java.util.List;
//@Controller
//@RequestMapping("/bookSlot")
//public class BookingController {
//
////    @GetMapping("/{date}/{hour}")
////    public String bookTimeSlot(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
////                               @PathVariable("hour") int hour,
////                               Model model) {
////        // Here you can implement your booking logic to book the time slot for the given date and hour.
////        // You can pass any necessary data to the booking page via the model.
////        model.addAttribute("date", date);
////        model.addAttribute("hour", hour);
////        return "appointment";
////    }
//
//}