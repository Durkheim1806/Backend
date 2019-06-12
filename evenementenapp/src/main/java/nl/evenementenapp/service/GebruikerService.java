package nl.evenementenapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.evenementenapp.domain.Artiest;
import nl.evenementenapp.domain.Evenement;
import nl.evenementenapp.domain.Gebruiker;
import nl.evenementenapp.repository.GebruikerRepository;

@Service
@Transactional
public class GebruikerService {

	@Autowired
	private GebruikerRepository gebruikerRepository;
	
	public Gebruiker save(Gebruiker gebruiker) {
		return gebruikerRepository.save(gebruiker);
	}
	
	public Optional<Gebruiker> findById(long id) {
		return gebruikerRepository.findById(id);
	}
	
	public Iterable<Gebruiker> findAll() {
		return gebruikerRepository.findAll();
	}

	public void deleteById(long id) {
		gebruikerRepository.deleteById(id);
	}
	
	public Iterable<Gebruiker> findByNaam(String name) {
		return gebruikerRepository.findByNaamContainingOrderByNaam(name);
	}
}
