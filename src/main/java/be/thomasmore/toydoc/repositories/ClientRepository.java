package be.thomasmore.toydoc.repositories;

import be.thomasmore.toydoc.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ClientRepository extends CrudRepository<Client, Integer> {
}
