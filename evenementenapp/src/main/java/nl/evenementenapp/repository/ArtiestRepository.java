package nl.evenementenapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import nl.evenementenapp.domain.Artiest;


@Repository
public interface ArtiestRepository extends CrudRepository<Artiest, Long> {
	
	
		Iterable<Artiest> findByNaamContaining(String naam);
		Iterable<Artiest> findByNaamContainingOrderByNaam(String naam);
		
		
}
