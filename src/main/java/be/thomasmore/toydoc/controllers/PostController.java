package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.model.Post;
import be.thomasmore.toydoc.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping({"/post-home"})
    public String post(Model model){
        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "post-home";
    }

    @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model){
        //find post by id
        Optional<Post> optionalPost = postService.getById(id);
        //if the post exists, then shove it into the model
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "post";
        }else{
            return "error";
        }
    }
}
