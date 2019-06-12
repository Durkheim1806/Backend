package nl.evenementenapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.evenementenapp.domain.Artiest;
import nl.evenementenapp.domain.Evenement;
import nl.evenementenapp.domain.Locatie;
import nl.evenementenapp.repository.LocatieRepository;

@Service
@Transactional
public class LocatieService {

	@Autowired
	private LocatieRepository locatieRepository;
	
	public Locatie save(Locatie locatie) {
		return locatieRepository.save(locatie);
	}
	
	public Optional<Locatie> findById(long id) {
		return locatieRepository.findById(id);
	}
	
	public Iterable<Locatie> findAll() {
		return locatieRepository.findAll();
	}

	public void deleteById(long id) {
		locatieRepository.deleteById(id);
	}
	
	public Iterable<Locatie> findByNaam(String name) {
		return locatieRepository.findByNaamContainingOrderByNaam(name);
	}
	
}
