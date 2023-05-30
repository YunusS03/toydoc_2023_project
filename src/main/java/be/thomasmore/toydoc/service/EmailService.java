package be.thomasmore.toydoc.service;

import be.thomasmore.toydoc.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    String websiteName = "localhost:8080";  // gebruik dit voor de lokale versie
    // String websiteName = "https://speelgoeddokter.onrender.com/"; // gebruik dit voor de online versie

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    private String generateAppointmentUrl(String secretKey){
        String url = "http://" + websiteName + "/appointment/email/" + secretKey;  //HTTPS WERKT NIET BIJ LOCALHOST
        return url;
    }

    private String generatePasswordResetUrl(String secretKey){
        String url = "http://" + websiteName + "/user/password-reset/" + secretKey;  //HTTPS WERKT NIET BIJ LOCALHOST
        return url;
    }


    public void sendAppointmentConfirmation(String recipientEmail, String date, int hour, String firstName, String lastName, String secretKey) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Appointment Confirmation for " + date + " at " + hour + ":00");
        StringBuilder sb = new StringBuilder();
        sb.append("Dear ").append(firstName).append(" ").append(lastName).append(",\n\n")
                .append("Thank you for scheduling an appointment with us. Your appointment is scheduled for ")
                .append(date).append(" at ").append(hour).append(":00. \n")
                .append("To confirm your appointment, please click on the following link within 24 hours:\n")
                .append(generateAppointmentUrl(secretKey)).append("\n\n")
                .append("Please note that your appointment will only be valid once confirmed within 24 hours.\n")
                .append("If you fail to confirm within the specified time, your appointment may be canceled.\n\n")
                .append("We look forward to seeing you soon!\n\n")
                .append("Best regards,\n")
                .append("Your ToyDoc appointment team");
        message.setText(sb.toString());
        mailSender.send(message);
    }




    public void sendAppointmentCancellation(String recipientEmail, String firstName, String lastName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Appointment Cancelled");
        StringBuilder sb = new StringBuilder();
        sb.append("Dear ").append(firstName).append(" ").append(lastName).append(",\n\n")
                .append("We regret to inform you that your appointment has been cancelled. If you have any questions or need further assistance, please contact us at ")
                .append("+3200000000").append(".\n\n")
                .append("We apologize for any inconvenience caused.\n\n")
                .append("Best regards,\n")
                .append("Your ToyDoc appointment team");
        message.setText(sb.toString());
        mailSender.send(message);
    }

    public void sendContactConfirm(String email,String name){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("[SUPPORT] Thank you for reaching us");
        StringBuilder sb = new StringBuilder();
        sb.append("Dear ").append(name).append(",\n\n")
                .append("We appreciate you taking the time to reach out to our team. ").append(".\n\n")
                .append("Don't worry — we've received your request and one of our team members will be in touch shortly.").append(".\n\n")
                .append("This is a auto-reply message.Please do not answer this message.\n\n")
                .append("Best regards,\n")
                .append("Your ToyDoc appointment team");
        message.setText(sb.toString());
        mailSender.send(message);
    }

    public void sendReply(String email,String name,String reply){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("[SUPPORT] ToyDoc Message");
        StringBuilder sb = new StringBuilder();
        sb.append("Dear ").append(name).append(",\n\n")
                .append(reply).append(".\n\n")
                .append("Best regards,\n")
                .append("Your ToyDoc appointment team");
        message.setText(sb.toString());
        mailSender.send(message);
    }




    public void sendAutoCanceledAppointmentNotification(String recipientEmail, String firstName, String lastName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Appointment Cancelled");
        StringBuilder sb = new StringBuilder();
        sb.append("Dear ").append(firstName).append(" ").append(lastName).append(",\n\n")
                .append("We regret to inform you that your appointment has been cancelled as it was not confirmed within 24 hours. If you have any questions or need further assistance, please contact us at ")
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


    public void sendPasswordResetEmail(String recipientEmail,String secretKey) {
        String resetUrl = generatePasswordResetUrl(secretKey);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Password Reset");
        StringBuilder sb = new StringBuilder();
        sb.append("Dear user,\n\n")
                .append("You have requested to reset your password. Please click the link below to proceed:\n\n")
                .append(resetUrl).append("\n\n")
                .append("If you did not initiate this password reset, please ignore this email.\n\n")
                .append("Best regards,\n")
                .append("Your ToyDoc team");
        message.setText(sb.toString());
        mailSender.send(message);
    }





}
