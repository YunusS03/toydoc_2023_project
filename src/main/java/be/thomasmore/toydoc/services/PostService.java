package be.thomasmore.toydoc.services;

import be.thomasmore.toydoc.model.Post;
import be.thomasmore.toydoc.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Optional<Post> getById(Integer id){
        return postRepository.findById(id);
    }
    public Post save (Post post){
        return postRepository.save(post);
    }
}
