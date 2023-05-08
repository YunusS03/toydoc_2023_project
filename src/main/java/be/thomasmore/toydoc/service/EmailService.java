package be.thomasmore.toydoc.service;

import be.thomasmore.toydoc.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    String websiteName = "localhost:8080";

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    private String generateAppointmentUrl(String secretKey){
        String url = "http://" + websiteName + "/appointment/email/" + secretKey;  //HTTPS WERKT NIET BIJ LOCALHOST
        return url;
    }


    public void sendAppointmentConfirmation(String recipientEmail, String date, int hour, String firstName, String lastName, String secretKey) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Appointment Confirmation" + date + " at " + hour);
        StringBuilder sb = new StringBuilder();
        sb.append("Dear ").append(firstName).append(" ").append(lastName).append(",\n\n")
                .append("Thank you for scheduling an appointment with us. Your appointment is scheduled for ")
                .append(date).append(" at ").append(hour).append(":00. \n")
                .append("To confirm your appointment, please click on the following link:\n")
                .append(generateAppointmentUrl(secretKey)).append("\n\n")
                .append("We look forward to seeing you soon!\n\n")
                .append("Best regards,\n")
                .append("Your ToyDoc appointment team");
        message.setText(sb.toString());
        mailSender.send(message);
    }



    public void sendAppointmentCancellation(String recipientEmail, String date, int hour, String firstName, String lastName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Appointment Cancellation: " + date + " at " + hour);
        StringBuilder sb = new StringBuilder();
        sb.append("Dear ").append(firstName).append(" ").append(lastName).append(",\n\n")
                .append("We regret to inform you that your appointment scheduled for ")
                .append(date).append(" at ").append(hour).append(":00 has been cancelled. If you have any questions or need further assistance, please contact us at ")
                .append("+3200000000").append(".\n\n")
                .append("We apologize for any inconvenience caused.\n\n")
                .append("Best regards,\n")
                .append("Your ToyDoc appointment team");
        message.setText(sb.toString());
        mailSender.send(message);
    }


    public void sendAppointmentReminder(String recipientEmail, String date, int hour, String firstName, String lastName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Appointment Reminder: " + date + " at " + hour);
        StringBuilder sb = new StringBuilder();
        sb.append("Dear ").append(firstName).append(" ").append(lastName).append(",\n\n")
                .append("Just a friendly reminder that you have an appointment with us scheduled for  ")
                .append(date).append(" at ").append(hour).append(":00. \n If you need to reschedule or cancel your appointment, please call us at ")
                .append("+3200000000").append(".\n\n")
                .append("We look forward to seeing you soon!\n\n")
                .append("Best regards,\n")
                .append("Your ToyDoc appointment team");
        message.setText(sb.toString());
        mailSender.send(message);
    }




}
