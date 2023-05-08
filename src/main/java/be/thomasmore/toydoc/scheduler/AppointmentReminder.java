package be.thomasmore.toydoc.scheduler;

import be.thomasmore.toydoc.model.Appointment;
import be.thomasmore.toydoc.repositories.AppointmentRepository;
import be.thomasmore.toydoc.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class AppointmentReminder {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentReminder(EmailService emailService) {
        this.emailService = emailService;
    }


    EmailService emailService;

    @Scheduled(cron = "0 0 7 * * ?") // Run every day at 7 AM
    public void sendAppointmentReminders() {

        LocalDate today = LocalDate.now();

        LocalDate tomorrowDate = today.plus(1, ChronoUnit.DAYS);

        java.util.Date tomorrow = java.sql.Date.valueOf(tomorrowDate);

        List<Appointment> appointments = appointmentRepository.findByDate(tomorrow);

        for (Appointment appointment : appointments) {
            System.out.println("Sended Reminder mail to : " + appointment.getClient().getEmail() + "\n");
             emailService.sendAppointmentReminder(appointment.getClient().getEmail(), appointment.getDate().toString(), getHourFromDate(appointment.getTime()), appointment.getClient().getFirstName(), appointment.getClient().getLastName());
        }

    }


    public int getHourFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour;
    }
}
