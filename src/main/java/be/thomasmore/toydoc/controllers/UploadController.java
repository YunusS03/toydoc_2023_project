package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.service.GoogleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @Autowired
    private GoogleService googleService;

    public UploadController(GoogleService googleService) {
        this.googleService = googleService;
    }


    @GetMapping("/upload")
    public String uploadForm(Model model, MultipartFile file) throws IOException {
        model.addAttribute("file", file);
        return "upload";
    }

    @PostMapping("/uploadsubmit")
    public String uploadSubmit(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        googleService.uploadFile(file);
        return "redirect:upload";
    }
}
