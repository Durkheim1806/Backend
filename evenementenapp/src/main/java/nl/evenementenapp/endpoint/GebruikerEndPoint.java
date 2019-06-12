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
import nl.evenementenapp.domain.Gebruiker;
import nl.evenementenapp.service.ArtiestService;
import nl.evenementenapp.service.EvenementService;
import nl.evenementenapp.service.GebruikerService;

@RestController
@RequestMapping("gebruiker")
public class GebruikerEndPoint {
	@Autowired
	GebruikerService gebruikerService;
	@Autowired
	EvenementService evenementService;

	@PostMapping
	public ResponseEntity<Gebruiker> aanmaken(@RequestBody Gebruiker g) { 
		if (g.getId() != 0) {
			return new ResponseEntity<> (HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Gebruiker>(gebruikerService.save(g), HttpStatus.OK); 
	}
	
	//curl -X GET http://localhost:8080/gebruiker/query?name=Z
	@RequestMapping(value="query", method=RequestMethod.GET)  
	public Iterable<Gebruiker> selectieOpvragen(@RequestParam(
			required=false, defaultValue="A") String name ) {
		return gebruikerService.findByNaam(name);
	}
	
	//curl -X GET http://localhost:8080/gebruiker/2
	@RequestMapping(path= "{id}", method=RequestMethod.GET)
	Optional<Gebruiker> getLid(@PathVariable long id) {
	return gebruikerService.findById(id);
	}
	
	//curl -X GET http://localhost:8080/gebruiker/
	@GetMapping
	public Iterable<Gebruiker> vindAlles() {								
		Iterable<Gebruiker> gebruikers = this.gebruikerService.findAll();
		return gebruikers;
	}
	
	//curl -X PUT http://localhost:8080/gebruiker/addEvent/14/3
	@PutMapping(value="addEvent/{gebrId}/{eveId}")
	public ResponseEntity<Gebruiker> apiAddEve(
			@PathVariable("gebrId") long gId,
			@PathVariable("eveId") long eId) {
		
		Optional<Evenement> optEvenement = evenementService.findById(eId);
			if (!optEvenement.isPresent()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Optional<Gebruiker> optGebruiker = gebruikerService.findById(gId);
			if (!optGebruiker.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			Evenement evenement = optEvenement.get();
			Gebruiker gebruiker = optGebruiker.get();
			if (!gebruiker.addEvenement(evenement)) {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
			}
			return new ResponseEntity<>(
			gebruikerService.save(gebruiker),
			HttpStatus.OK);
			}
	
	//curl -X DELETE http://localhost:8080/artiest/14
	@DeleteMapping(path="{id}")
	public ResponseEntity<Gebruiker> apiDeleteById(@PathVariable("id") long id) {
		if (gebruikerService.findById(id).isPresent() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			gebruikerService.deleteById(id);
	return new ResponseEntity<>(HttpStatus.OK);
	}
	}
}

