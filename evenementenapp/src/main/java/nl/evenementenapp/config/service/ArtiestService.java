package nl.evenementenapp.config.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.evenementenapp.domain.Artiest;
import nl.evenementenapp.repository.ArtiesRepository;

@Service
@Transactional
public class ArtiestService {

	@Autowired
	private ArtiestRepository artiestRepository;
	
	public Artiest save(Arties artiest) {
		return artiesRepository.save(arties);
	}
	
	
}
