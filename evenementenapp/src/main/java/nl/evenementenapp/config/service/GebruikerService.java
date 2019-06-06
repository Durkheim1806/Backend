package nl.evenementenapp.config.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
}
