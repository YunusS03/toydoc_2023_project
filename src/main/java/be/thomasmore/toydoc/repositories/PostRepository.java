package be.thomasmore.toydoc.repositories;


import be.thomasmore.toydoc.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;



public interface PostRepository extends CrudRepository<Post, Integer> {
    List<Post> findAllBy();

    @Override
    Optional<Post> findById(Integer integer);

    Optional<Post> findFirstByIdLessThanOrderByIdDesc(int id);

    Optional<Post> findFirstByIdGreaterThanOrderById(int id);
    Optional<Post> findFirstByOrderByIdDesc();
    Optional<Post> findFirstByOrderByIdAsc();

}
