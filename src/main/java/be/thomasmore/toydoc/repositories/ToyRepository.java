package be.thomasmore.toydoc.repositories;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Appointment;
import be.thomasmore.toydoc.model.Toy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ToyRepository extends CrudRepository<Toy, Integer> {
    List<Toy> findByClient(AppUser Appuser);
    List<Toy> findByAppointment(Appointment appointment);
    void deleteByClient_Id(Integer id);
    void deleteAllByClient(AppUser appUser);

}
