package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Post;
import be.thomasmore.toydoc.repositories.PostRepository;
import be.thomasmore.toydoc.services.AppUserService;
import be.thomasmore.toydoc.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PostService postService;
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
        model.addAttribute("post", new Post());
        return "post_new";
    }
    @PostMapping("/posts/new")
    public String saveNewPost(Model model, Principal principal,
                              @RequestParam("title") String title,
                              @RequestParam("body") String body,
                              @RequestParam("date") Date date,
                              @RequestParam("appuser") AppUser appUser) throws ParseException {
        final String loginName = principal == null ? "NOBODY" : principal.getName();
        // Voeg de naam van de ingelogde gebruiker toe aan het Model
        model.addAttribute("loginName", loginName);
        Post post = new Post();
        postRepository.save(post);
        return "redirect:/sendEmail";
    }

}
