package be.thomasmore.toydoc.repositories;


import be.thomasmore.toydoc.model.Liking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LikingRepository extends CrudRepository<Liking, Integer> {


}
