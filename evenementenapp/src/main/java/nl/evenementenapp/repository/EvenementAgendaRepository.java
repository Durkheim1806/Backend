package nl.evenementenapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import nl.evenementenapp.domain.EvenementenAgenda;

@Repository
public interface EvenementAgendaRepository extends CrudRepository<EvenementenAgenda, Long> {

}
