package nl.evenementenapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
}
