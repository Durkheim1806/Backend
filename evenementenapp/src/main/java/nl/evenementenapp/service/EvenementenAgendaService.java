package nl.evenementenapp.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.evenementenapp.domain.Artiest;
import nl.evenementenapp.domain.EvenementenAgenda;
import nl.evenementenapp.repository.EvenementenAgendaRepository;

@Service
@Transactional
public class EvenementenAgendaService {

	@Autowired
	private EvenementenAgendaRepository evenementenAgendaRepository;
	
	public EvenementenAgenda save(EvenementenAgenda evenementenAgenda) {
		return evenementenAgendaRepository.save(evenementenAgenda);
	}
	
	public Optional<EvenementenAgenda> findById(long id) {
		return evenementenAgendaRepository.findById(id);
	}
	
	public Iterable<EvenementenAgenda> findAll() {
		return evenementenAgendaRepository.findAll();
	}

	public void deleteById(long id) {
		evenementenAgendaRepository.deleteById(id);
	}
	
	public Iterable<EvenementenAgenda> findByNaam(String name) {
		return evenementenAgendaRepository.findByNaamContainingOrderByNaam(name);
	}
	
}
