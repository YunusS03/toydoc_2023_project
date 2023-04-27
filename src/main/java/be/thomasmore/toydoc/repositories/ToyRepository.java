package be.thomasmore.toydoc.repositories;

import be.thomasmore.toydoc.model.Toy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ToyRepository extends CrudRepository<Toy, Integer> {
}
