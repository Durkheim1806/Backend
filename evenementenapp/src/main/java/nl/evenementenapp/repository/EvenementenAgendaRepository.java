package nl.evenementenapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nl.evenementenapp.domain.Artiest;
import nl.evenementenapp.domain.EvenementenAgenda;

@Repository
public interface EvenementenAgendaRepository extends CrudRepository<EvenementenAgenda, Long> {

	Iterable<EvenementenAgenda> findByNaamContaining(String naam);
	Iterable<EvenementenAgenda> findByNaamContainingOrderByNaam(String naam);
	
}
