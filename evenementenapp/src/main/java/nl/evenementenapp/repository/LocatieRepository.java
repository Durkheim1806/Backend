package nl.evenementenapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import nl.evenementenapp.domain.Locatie;

@Repository
public interface LocatieRepository extends CrudRepository<Locatie, Long>{

}
