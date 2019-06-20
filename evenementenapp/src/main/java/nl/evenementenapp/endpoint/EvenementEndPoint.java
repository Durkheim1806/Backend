package nl.evenementenapp.endpoint;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import nl.evenementenapp.domain.Artiest;
import nl.evenementenapp.domain.Evenement;
import nl.evenementenapp.domain.EvenementenAgenda;
import nl.evenementenapp.service.EvenementService;
import nl.evenementenapp.service.EvenementenAgendaService;

@RestController
@RequestMapping("evenement")
public class EvenementEndPoint {
	@Autowired
	EvenementService evenementService;
		
	// create
	@PostMapping
	public ResponseEntity<Evenement> aanmaken(@RequestBody Evenement e) { 
		if (e.getId() != 0) {
			return new ResponseEntity<> (HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Evenement>(evenementService.save(e), HttpStatus.OK); 
	}
	
	// retrieve
	//curl -X GET http://localhost:8080/evenement/query?name=Z
		@GetMapping(path="query")  
		public Iterable<Evenement> selectieOpvragen(@RequestParam(
				required=false, defaultValue="A") String name ) {
			return evenementService.findByNaam(name);
		}
		
		//curl -X GET http://localhost:8080/evenement/2
		@GetMapping(path= "{id}")
		Optional<Evenement> getLid(@PathVariable long id) {
		return evenementService.findById(id);
		}
		
		//curl -X GET http://localhost:8080/evenement/
		@GetMapping
		public Iterable<Evenement> vindAlles() {								
			Iterable<Evenement> evenementen = this.evenementService.findAll();
			return evenementen;
		}
		
		// Retrieve
		@GetMapping("getEvenement") 	
		public ResponseEntity<Iterable<Evenement>> apiGetAll() {
			return new ResponseEntity<Iterable<Evenement>>(
					evenementService.findAll(), 
					HttpStatus.OK);
		}
		
		
		//curl -X DELETE http://localhost:8080/artiest/14
		@DeleteMapping(path="{id}")
		public ResponseEntity<Evenement> apiDeleteById(@PathVariable("id") long id) {
			if (evenementService.findById(id).isPresent() == false) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				evenementService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		}
		}
	
	
}
