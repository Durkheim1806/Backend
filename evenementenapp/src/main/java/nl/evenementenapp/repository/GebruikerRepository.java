package nl.evenementenapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import nl.evenementenapp.domain.Gebruiker;

@Repository
public interface GebruikerRepository extends CrudRepository<Gebruiker, Long>{

}
