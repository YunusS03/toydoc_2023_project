package be.thomasmore.toydoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendAppointmentURL(String recipientEmail, String secretKey) {
        String websiteName = "localhost:8080";

        // Create the URL using the website name and secret key
        String url = "https://" + websiteName + "/appointment?secretKey=" + secretKey;

        // Create the email message
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Your appointment URL");
        message.setText("Please click on the following link to manage your appointment:\n" + url);

        // Send the email
        mailSender.send(message);
    }


    public void sendAppointmentConfirmation(String recipientEmail, String date, int hour, String firstName, String lastName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Appointment " + date + " at " + hour);
        StringBuilder sb = new StringBuilder();
        sb.append("Dear ").append(firstName).append(" ").append(lastName).append(",\n\n")
                .append("Thank you for scheduling an appointment with us. Your appointment is scheduled for ")
                .append(date).append(" at ").append(hour).append(":00. If you need to reschedule or cancel your appointment, please call us at ")
                .append("+3200000000").append(".\n\n")
                .append("We look forward to seeing you soon!\n\n")
                .append("Best regards,\n")
                .append("Your ToyDoc appointment team aka Yunus & Robin");
        message.setText(sb.toString());
        mailSender.send(message);
    }


}
