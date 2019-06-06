package nl.evenementenapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import nl.evenementenapp.domain.Evenement;

@Repository
public interface EvenementRepository extends CrudRepository<Evenement, Long> {

}
