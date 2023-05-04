package be.thomasmore.toydoc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



//@RestController
//public class EmailController {
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    @GetMapping("/sendEmail")
//    public String sendEmail() {
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo("janssensrobin@live.be");
//        msg.setSubject("Success!");
//        msg.setText("Your controller was accessed successfully.");
//
//        javaMailSender.send(msg);
//
//        return "Email send Succesfully";
//    }
//}
