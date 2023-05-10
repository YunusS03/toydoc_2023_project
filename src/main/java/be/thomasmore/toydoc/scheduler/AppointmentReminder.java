package be.thomasmore.toydoc.scheduler;

import be.thomasmore.toydoc.model.Appointment;
import be.thomasmore.toydoc.repositories.AppointmentRepository;
import be.thomasmore.toydoc.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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


    @Scheduled(cron = "0 0 * * * ?") // Run every hour
    public void checkUnconfirmedAppointments() {
        Date now = new Date();

        List<Appointment> appointments = appointmentRepository.findByConfirmedFalse();

        int countWaiting =0;
        int countDeleted =0;
        for (Appointment appointment : appointments) {
            long hoursSinceAppointment = getHoursBetweenDates(appointment.getCreationTime(),now);

            System.out.println(appointment.getClient().getEmail() + " HAS NOT CONFIRMED " + appointment.getCreationTime() + " HOURS ELAPSED = " + hoursSinceAppointment );


            if (hoursSinceAppointment >= 24) {
                appointmentRepository.delete(appointment);
                System.out.println("Deleted unconfirmed appointment from: " + appointment.getClient().getEmail());
                emailService.sendAutoCanceledAppointmentNotification(appointment.getClient().getEmail(),appointment.getClient().getFirstName(),appointment.getClient().getLastName());
                countDeleted++;
            } else {
                System.out.println("\nAppointment is still within the confirmation period  FROM "  + appointment.getClient().getEmail());
            countWaiting++;
            }
        }
        System.out.println("=====================APOINTMENT SCHEDULER INFO============================");
        System.out.println("DELETED APPOINTMENTS BY CONFIRM EXPIRY -> " + countDeleted);
        System.out.println("Appointments not yet expired -> " + countWaiting);
        System.out.println("=====================APOINTMENT SCHEDULER INFO============================");
    }

    public long getHoursBetweenDates(Date startDate, Date endDate) {
        long diffInMillis = endDate.getTime() - startDate.getTime();
        return TimeUnit.HOURS.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }



    public int getHourFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour;
    }









}
