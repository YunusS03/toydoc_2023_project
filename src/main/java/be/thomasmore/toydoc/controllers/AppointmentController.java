package be.thomasmore.toydoc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppointmentController {
    @GetMapping("/")
    public String appointment() {
        return "appointment";
    }

    @GetMapping("/test")
    public String test() {
        return "appointment";
    }
}
