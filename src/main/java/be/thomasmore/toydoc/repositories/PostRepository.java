package be.thomasmore.toydoc.repositories;


import be.thomasmore.toydoc.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;



public interface PostRepository extends CrudRepository<Post, Integer> {

    List<Post> findBySpecialty(String speciality);
    List<Post> findAll();

    @Override
    Optional<Post> findById(Integer integer);

    @Query("SELECT p.likeCount FROM Post p WHERE p.id = : postId")
    Integer findLikeCountById(int postId);

    Optional<Post> findFirstByIdLessThanOrderByIdDesc(int id);

    Optional<Post> findFirstByIdGreaterThanOrderById(int id);
    Optional<Post> findFirstByOrderByIdDesc();
    Optional<Post> findFirstByOrderByIdAsc();

}
