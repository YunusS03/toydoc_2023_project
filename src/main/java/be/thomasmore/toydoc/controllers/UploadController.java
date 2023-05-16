package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.service.GoogleService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.UUID;
import java.util.logging.Logger;


@Controller
public class UploadController {
    private Logger logger = Logger.getLogger(UploadController.class.getName());
    @Autowired
    private GoogleService googleService;

    public UploadController(GoogleService googleService) {
        this.googleService = googleService;
    }


    @GetMapping("/user/upload")
    public String uploadForm(Model model, MultipartFile file) throws IOException {
        model.addAttribute("file", file);
        return "upload";
    }

    @PostMapping("/user/uploadsubmit")
    public String uploadSubmit(@RequestParam("file") MultipartFile file,
                               Model model, Principal principal) throws IOException, FirebaseAuthException {
        googleService.uploadFile(file, principal);
        return "home";
    }

}
