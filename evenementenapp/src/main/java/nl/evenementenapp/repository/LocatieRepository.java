package nl.evenementenapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.evenementenapp.domain.Artiest;
import nl.evenementenapp.domain.Locatie;

@Repository
public interface LocatieRepository extends CrudRepository<Locatie, Long>{

	
	Iterable<Locatie> findByNaamContaining(String naam);
	Iterable<Locatie> findByNaamContainingOrderByNaam(String naam);
}
