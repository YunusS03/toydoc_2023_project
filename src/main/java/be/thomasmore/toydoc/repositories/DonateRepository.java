package be.thomasmore.toydoc.repositories;

import be.thomasmore.toydoc.model.Donation;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;

public interface DonateRepository extends CrudRepository<Donation, Integer> {
}