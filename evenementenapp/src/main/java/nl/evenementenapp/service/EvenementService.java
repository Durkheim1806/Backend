package nl.evenementenapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.evenementenapp.domain.Evenement;
import nl.evenementenapp.repository.EvenementRepository;

@Service
@Transactional
public class EvenementService {

	@Autowired
	private EvenementRepository evenementRepository;
	
	public Evenement save(Evenement evenement) {
		return evenementRepository.save(evenement);
	}
	
}
