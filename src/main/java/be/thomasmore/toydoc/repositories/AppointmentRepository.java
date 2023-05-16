package be.thomasmore.toydoc.repositories;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
//    Optional<Appointment> findFirstByIdLessThanOrderByIdDesc(int id);
//    Optional<Appointment> findFirstByIdGreaterThanOrderById(int id);
//    Optional<Appointment> findFirstByOrderByIdDesc();
//    Optional<Appointment> findFirstByOrderByIdAsc();
    List<Appointment> findAllBy();
    Appointment findBySecretKey(String secretKey);
    List<Appointment> findByDate(Date date);
    List<Appointment> findByConfirmedFalse();
    List<Appointment> findByClient(AppUser Appuser);
    void deleteById(Integer id);




}
