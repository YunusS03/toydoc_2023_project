package be.thomasmore.toydoc.service;

public interface EmailSenderService {
    void sendEmail(String to, String subject, String message);
}
