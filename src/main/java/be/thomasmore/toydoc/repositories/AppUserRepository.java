package be.thomasmore.toydoc.repositories;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Role;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    AppUser findByUsername(String username);
//    @Query("SELECT u.role FROM AppUser u ORDER BY u.id ASC WHERE u.role = ?1")
//    Iterable<AppUser> findByRole(Role role);


    @Query("SELECT u FROM AppUser u WHERE u.role = :role ORDER BY u.id ASC")
    AppUser findByRole(@Param("role") Role role);

    @Query("SELECT u FROM AppUser u WHERE u.role = :role ORDER BY u.id ASC")
    List<AppUser> findByRoleList(@Param("role") Role role);

    @Query("SELECT u FROM AppUser u WHERE u.role = :role AND u.username = :username")
    AppUser findByRoleAndUsername(@Param("role") Role role, @Param("username") String username);
}
