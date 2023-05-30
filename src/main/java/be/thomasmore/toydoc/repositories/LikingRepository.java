package be.thomasmore.toydoc.repositories;


import be.thomasmore.toydoc.model.Liking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LikingRepository extends CrudRepository<Liking, Integer> {
    boolean existsByPostIdAndAppUser(Integer postId, Integer appUserID);

    List<Liking> findByPostIdAndAppUser(Integer id, Integer id1);



}
