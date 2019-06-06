package nl.evenementenapp.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.evenementenapp.domain.Artiest;
import nl.evenementenapp.repository.ArtiestRepository;

@Service
@Transactional
public class ArtiestService {

	@Autowired
	private ArtiestRepository artiestRepository;
	
	public Artiest save(Artiest artiest) {
		return artiestRepository.save(artiest);
	}
	
	
}
