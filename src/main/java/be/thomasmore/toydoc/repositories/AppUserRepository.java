package be.thomasmore.toydoc.repositories;

import be.thomasmore.toydoc.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
   ;

    AppUser findByUsername(String username);
}
