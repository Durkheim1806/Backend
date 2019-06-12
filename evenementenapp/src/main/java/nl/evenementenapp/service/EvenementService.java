package nl.evenementenapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.evenementenapp.domain.Evenement;
import nl.evenementenapp.domain.EvenementenAgenda;
import nl.evenementenapp.repository.EvenementRepository;

@Service
@Transactional
public class EvenementService {

	@Autowired
	private EvenementRepository evenementRepository;
	
	public Evenement save(Evenement evenement) {
		return evenementRepository.save(evenement);
	}
	
	public Optional<Evenement> findById(long id) {
		return evenementRepository.findById(id);
	}
	
	public Iterable<Evenement> findAll() {
		return evenementRepository.findAll();
	}

	public void deleteById(long id) {
		evenementRepository.deleteById(id);
	}
	
	public Iterable<Evenement> findByNaam(String name) {
		return evenementRepository.findByNaamContainingOrderByNaam(name);
	}
}
