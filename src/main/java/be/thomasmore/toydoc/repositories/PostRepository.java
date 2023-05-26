package be.thomasmore.toydoc.repositories;


import be.thomasmore.toydoc.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

    @Override
    Optional<Post> findById(Integer integer);

    @Override
    Iterable<Post> findAll();
}
