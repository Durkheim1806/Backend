package nl.evenementenapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.evenementenapp.domain.Artiest;
import nl.evenementenapp.domain.Gebruiker;

@Repository
public interface GebruikerRepository extends CrudRepository<Gebruiker, Long>{

	
	Iterable<Gebruiker> findByNaamContaining(String naam);
	Iterable<Gebruiker> findByNaamContainingOrderByNaam(String naam);
}
