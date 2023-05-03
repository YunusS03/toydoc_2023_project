package be.thomasmore.toydoc.repositories;

import be.thomasmore.toydoc.model.Donation;
import org.springframework.data.repository.CrudRepository;

public interface DonationRepository extends CrudRepository<Donation, Integer> {
}