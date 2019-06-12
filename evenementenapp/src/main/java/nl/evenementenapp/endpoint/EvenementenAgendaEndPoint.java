package nl.evenementenapp.endpoint;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import nl.evenementenapp.domain.EvenementenAgenda;
import nl.evenementenapp.service.EvenementenAgendaService;


@RestController
@RequestMapping("evenementenagenda")
public class EvenementenAgendaEndPoint {
	@Autowired
	EvenementenAgendaService evenementenAgendaService;
		
	@PostMapping
	public ResponseEntity<EvenementenAgenda> aanmaken(@RequestBody EvenementenAgenda ea) { 
		if (ea.getId() != 0) {
			return new ResponseEntity<> (HttpStatus.CONFLICT);
		}
		return new ResponseEntity<EvenementenAgenda>(evenementenAgendaService.save(ea), HttpStatus.OK); 
	}
	
	//curl -X GET http://localhost:8080/evenementenagenda/query?name=Z
	@RequestMapping(value="query", method=RequestMethod.GET)  
	public Iterable<EvenementenAgenda> selectieOpvragen(@RequestParam(
			required=false, defaultValue="A") String name ) {
		return evenementenAgendaService.findByNaam(name);
	}
	
	//curl -X GET http://localhost:8080/evenementenagenda/2
	@RequestMapping(path= "{id}", method=RequestMethod.GET)
	Optional<EvenementenAgenda> getLid(@PathVariable long id) {
	return evenementenAgendaService.findById(id);
	}
	
	//curl -X GET http://localhost:8080/evenementenagenda
	@GetMapping
	Iterable<EvenementenAgenda> vindAlles() {								
		Iterable<EvenementenAgenda> evenementenagendas = this.evenementenAgendaService.findAll();
		return evenementenagendas;
	}
	
	//curl -X DELETE http://localhost:8080/evenementenagenda/14
	@DeleteMapping(path="{id}")
	public ResponseEntity<EvenementenAgenda> apiDeleteById(@PathVariable("id") long id) {
		if (evenementenAgendaService.findById(id).isPresent() == false) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				evenementenAgendaService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	
				
}


