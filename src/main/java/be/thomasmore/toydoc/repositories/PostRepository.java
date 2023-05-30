package be.thomasmore.toydoc.repositories;


import be.thomasmore.toydoc.model.Appointment;
import be.thomasmore.toydoc.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import java.util.Date;
import java.util.List;


@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
    List<Post> findAllBy();

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

    @Query("SELECT p FROM Post p " +
            "WHERE ?1 IS NULL OR LOWER (p.title) LIKE LOWER(CONCAT('%',?1,'%'))" +
            "AND (?2 IS NULL OR p.id = ?2)" +
            "AND (?3 IS NULL OR p.date = ?3)"
    )
    List<Post> findPostFilter(String title, Integer id,Date date);
}
