package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.service.GoogleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class UploadController {
    @Autowired
    private GoogleService googleService;

    @GetMapping("/upload")
    public String upload(@RequestParam(required = false) MultipartFile image) {
        File pom = new File("./pom.xml");
        try {
            String url = googleService.toFirebase(pom, "pom.xml");
            System.out.println("File Upload Succesful at:"+url);
        } catch (Exception ex) {
            System.out.println("Niet gelukt " + ex.getMessage());
        }
        return "upload";
    }
}
