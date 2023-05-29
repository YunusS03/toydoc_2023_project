package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Post;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import be.thomasmore.toydoc.repositories.PostRepository;
import be.thomasmore.toydoc.service.GoogleService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.logging.Logger;


@Controller
public class UploadController {
    private Logger logger = Logger.getLogger(UploadController.class.getName());
    @Autowired
    private GoogleService googleService;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PostRepository postRepository;

    public UploadController(GoogleService googleService) {
        this.googleService = googleService;
    }


    @GetMapping("/user/upload")
    public String uploadForm(Model model, MultipartFile file) {
        model.addAttribute("file", file);
        return "upload";
    }

    // Upload postmapping for the user pfp.
    @PostMapping("/user/uploadsubmit")
    public String uploadSubmit(@RequestParam("file") MultipartFile file,
                               HttpServletRequest request) throws IOException {
        // @RequestParam("file") MultipartFile file is used to get the file from the form. (the <input type="file" accept="image/*"> is required in the html-form.)
        // HttpServletRequest request is used to get the `appUser` from the request. See below.
        AppUser appUser = (AppUser) request.getAttribute("appUser");
        // "`AppUser appUser` declares the `appUser` variable of type `AppUser`."
        // "The `request` object refers to an instance of `HttpServletRequest`."
        // "The `getAttribute` method returns the value of the named attribute as an `Object`."
        // "The (AppUser) casts the `Object` to an `AppUser`." "This is called type casting."

        googleService.uploadFile(file); // Uploads the file to Firebase Storage. See GoogleService.
        appUser.setImageUrl(googleService.getSignedUrl()); // Sets the `imageUrl` of the `appUser` to the signed URL of the uploaded file as returned by GoogleService method `getSignedUrl`.
        appUserRepository.save(appUser); // Saves the `appUser` to the database.
        logger.info("File uploaded successfully." + googleService.getSignedUrl()); // Logs the signed URL of the uploaded file.
        return "redirect:/home"; // Redirects to the home page.
    }

    @PostMapping("/user/uploadbefore")
    public String uploadSubmitBefore(@RequestParam("file") MultipartFile file,
                               HttpServletRequest request) throws IOException {
        AppUser appUser = (AppUser) request.getAttribute("appUser");
        Post post = new Post();
        googleService.uploadFile(file); // Uploads the file to Firebase Storage. See GoogleService.
        post.setBeforeUrl(googleService.getSignedUrl()); // Sets the `imageUrl` of the `appUser` to the signed URL of the uploaded file as returned by GoogleService method `getSignedUrl`.
        appUserRepository.save(appUser); // Saves the `appUser` to the database.
        postRepository.save(post);
        logger.info("File uploaded successfully." + googleService.getSignedUrl()); // Logs the signed URL of the uploaded file.
        return "redirect:/postlist"; // Redirects to the home page.
    }
    @PostMapping("/user/uploadafter")
    public String uploadSubmitAfter(@RequestParam("file") MultipartFile file,
                                     HttpServletRequest request) throws IOException {
        AppUser appUser = (AppUser) request.getAttribute("appUser");
        Post post = new Post();
        googleService.uploadFile(file); // Uploads the file to Firebase Storage. See GoogleService.
        post.setAfterUrl(googleService.getSignedUrl()); // Sets the `imageUrl` of the `appUser` to the signed URL of the uploaded file as returned by GoogleService method `getSignedUrl`.
        appUserRepository.save(appUser); // Saves the `appUser` to the database.
        postRepository.save(post);
        logger.info("File uploaded successfully." + googleService.getSignedUrl()); // Logs the signed URL of the uploaded file.
        return "redirect:/postlist"; // Redirects to the home page.
    }

}
