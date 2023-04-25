package be.thomasmore.toydoc.repositories;

import be.thomasmore.toydoc.model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
//    Optional<Appointment> findFirstByIdLessThanOrderByIdDesc(int id);
//    Optional<Appointment> findFirstByIdGreaterThanOrderById(int id);
//    Optional<Appointment> findFirstByOrderByIdDesc();
//    Optional<Appointment> findFirstByOrderByIdAsc();
    List<Appointment> findAllBy();
}
