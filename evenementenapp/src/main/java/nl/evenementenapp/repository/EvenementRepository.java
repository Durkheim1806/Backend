package nl.evenementenapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import nl.evenementenapp.domain.Evenement;
import nl.evenementenapp.domain.EvenementenAgenda;

@Repository
public interface EvenementRepository extends CrudRepository<Evenement, Long> {
	
	Iterable<Evenement> findByNaamContaining(String naam);
	Iterable<Evenement> findByNaamContainingOrderByNaam(String naam);
	

}
