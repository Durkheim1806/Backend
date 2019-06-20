package nl.evenementenapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.evenementenapp.domain.Artiest;
import nl.evenementenapp.domain.Gebruiker;

@Repository
public interface GebruikerRepository extends CrudRepository<Gebruiker, Long>{

	
	Iterable<Gebruiker> findByNaamContaining(String naam);
	Iterable<Gebruiker> findByNaamContainingOrderByNaam(String naam);
	
	Optional<Gebruiker> findByGebruikersnaam(String gebruikersnaam);
}
