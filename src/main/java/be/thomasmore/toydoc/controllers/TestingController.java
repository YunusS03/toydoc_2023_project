package be.thomasmore.toydoc.controllers;


import be.thomasmore.toydoc.scheduler.AppointmentReminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestingController {


    private final AppointmentReminder appointmentReminder;


    @Autowired
    public TestingController(AppointmentReminder appointmentReminder) {
        this.appointmentReminder = appointmentReminder;
    }

    @GetMapping("/test-reminders")
    public String testReminders() {
        appointmentReminder.sendAppointmentReminders();
        return "test/test_reminders"; // Return the appropriate view
    }

    @GetMapping("/test-confirm")
    public String testconfirm() {
        appointmentReminder.checkUnconfirmedAppointments();
        return "test/test_reminders"; // Return the appropriate view
    }
}
