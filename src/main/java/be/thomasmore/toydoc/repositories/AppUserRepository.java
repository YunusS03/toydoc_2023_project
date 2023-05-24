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

    @Query("SELECT u FROM AppUser u " +
            "WHERE ?1 IS NULL OR LOWER (u.firstName) LIKE LOWER(CONCAT('%',?1,'%'))" +
            "AND  (?2 IS NULL OR u.role = ?2)" +
            "AND (?3 IS NULL OR u.speciality = ?3)"
    )
    List<AppUser> findByDoctorWithFilter(String keyword,Role role,String speciality);



    @Query("SELECT u FROM AppUser u WHERE u.role = :role AND u.username = :username")
    AppUser findByRoleAndUsername(@Param("role") Role role, @Param("username") String username);

    Optional<AppUser> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<AppUser> findFirstByIdGreaterThanOrderById(Integer id);

    Optional<AppUser> findFirstByOrderByIdDesc();

    Optional<AppUser> findFirstByOrderByIdAsc();

    AppUser findByEmail(String email);

    AppUser findByPasswordResetKey(String passwordResetKey);



    @Query("SELECT u FROM AppUser u " +
            "WHERE ?1 IS NULL OR LOWER (u.firstName) LIKE LOWER(CONCAT('%',?1,'%'))" +
            "AND  (?2 IS NULL OR u.role = ?2)"
    )
    List<AppUser> findByFirstNameContainingIgnoreCase(String keyword,Role role);

    List<AppUser> findByFirstName(String firstName);
    List<AppUser> findByLastName(String lastName);
    List<AppUser> findByCity(String city);
    List<AppUser> findByCountry(String country);
    List<AppUser> findByAgeGreaterThan(int age);
    List<AppUser> findByAgeLessThan(int age);
    List<AppUser> findByRoleAndCity(Role role, String city);
    List<AppUser> findBySpeciality(String speciality);
    List<AppUser> findByFirstNameAndLastName(String firstName, String lastName);
    List<AppUser> findByFirstNameOrLastName(String firstName, String lastName);

}
