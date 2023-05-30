package be.thomasmore.toydoc.repositories;

import be.thomasmore.toydoc.model.Appointment;
import be.thomasmore.toydoc.model.ContactMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ContactMessageRepository extends CrudRepository<ContactMessage,Integer> {
    List<ContactMessage> findByIsRead(Boolean isRead);

    List<ContactMessage> findAllBy();

    @Query("SELECT c FROM ContactMessage c " +
            "WHERE ?1 IS NULL OR LOWER (c.name) LIKE LOWER(CONCAT('%',?1,'%'))" +
            "AND (?2 IS NULL OR c.isRead = ?2)"

    )
    List<ContactMessage> findMessageWithFilter(String senderName, Boolean isRead);

}
