package be.thomasmore.toydoc.repositories;

import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.model.Appointment;
import be.thomasmore.toydoc.model.Role;
import org.springframework.data.jpa.repository.Query;
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

    List<Appointment> findByDoctor(AppUser appUser);

    @Query("SELECT a FROM Appointment a " +
            "WHERE ?1 IS NULL OR LOWER (a.doctor.firstName) LIKE LOWER(CONCAT('%',?1,'%'))" +
            "AND (?2 IS NULL OR LOWER (a.client.firstName) LIKE LOWER(CONCAT('%',?2,'%')))" +
            "AND (?3 IS NULL OR a.id = ?3)" +
            "AND (?4 IS NULL OR a.confirmed = ?4)" +
            "AND (?5 IS NULL OR a.date = ?5)"
    )
    List<Appointment> findAppointmentWithFilter(String doctorName, String clientName, Integer id,Boolean confirm,Date date);



    void deleteById(Integer id);
    List<Appointment> findAllByDoctor(AppUser appUser);


    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId")
    List<Appointment> findAllByDoctorId(Integer doctorId);
}
