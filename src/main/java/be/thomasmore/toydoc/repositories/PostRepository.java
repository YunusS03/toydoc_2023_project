package be.thomasmore.toydoc.repositories;


import be.thomasmore.toydoc.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;



public interface PostRepository extends CrudRepository<Post, Integer> {


    @Query("SELECT p FROM Post p WHERE p.specialty = :specialty")
    List<Post> findBySpecialty(@Param("specialty") String specialty);

    List<Post> findAll();

    Optional<Post> findById(Integer integer);

    Optional<Post> findFirstByIdLessThanOrderByIdDesc(int id);

    Optional<Post> findFirstByIdGreaterThanOrderById(int id);
    Optional<Post> findFirstByOrderByIdDesc();
    Optional<Post> findFirstByOrderByIdAsc();

}
