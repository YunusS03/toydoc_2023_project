package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Post;
import be.thomasmore.toydoc.repositories.PostRepository;
import be.thomasmore.toydoc.services.AppUserService;
import be.thomasmore.toydoc.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        Optional<AppUser> optionalAppUser = appUserService.findByEmail("justine.dor@hotmail.be");
        if (optionalAppUser.isPresent()) {
            Post post = new Post();
            post.setAppUser(optionalAppUser.get());
            model.addAttribute("post", post);
        }
        return "post_new";
    }

}
