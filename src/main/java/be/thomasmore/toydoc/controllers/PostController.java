package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Post;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import be.thomasmore.toydoc.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/post-home")
    public String postList(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "post-home";
    }

    @GetMapping("/postDetails/{id}")
    public String postDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "postDetails";
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            model.addAttribute("post", optionalPost.get());
        }
        return "postDetails";
    }


    @GetMapping("/posts/new")
    public String createNewPost(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "post_new";
    }

    @PostMapping("/posts/postnew")
    public String saveNewPost(Model model, Principal principal,
                              @RequestParam(required = false) String title,
                              @RequestParam(required = false) String body,
                              @RequestParam(required = false) Date date){
        final String loginName = principal == null ? "NOBODY" : principal.getName();
        // Voeg de naam van de ingelogde gebruiker toe aan het Model
        model.addAttribute("loginName", loginName);
        if (principal != null) {
            AppUser appUser = appUserRepository.findByUsername(principal.getName());
            model.addAttribute("client", appUser);
        }

        Post post = new Post(title, body, Date.from(java.time.LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        postRepository.save(post);
        return "redirect:/post-home";
    }

}
