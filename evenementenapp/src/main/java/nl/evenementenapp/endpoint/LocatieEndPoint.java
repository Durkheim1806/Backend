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

import nl.evenementenapp.domain.Locatie;
import nl.evenementenapp.service.LocatieService;

@RestController
@RequestMapping(path = "locatie") 
public class LocatieEndPoint {
	@Autowired
	LocatieService locatieService;

	@PostMapping
	public ResponseEntity<Locatie> aanmaken(@RequestBody Locatie l) { 
		if (l.getId() != 0) {
			return new ResponseEntity<> (HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Locatie>(locatieService.save(l), HttpStatus.OK); 
	}
	
	//curl -X GET http://localhost:8080/locatie/query?name=Z
	@RequestMapping(value="query", method=RequestMethod.GET)  
	public Iterable<Locatie> selectieOpvragen(@RequestParam(
			required=false, defaultValue="A") String name ) {
		return locatieService.findByNaam(name);
	}
	
	//curl -X GET http://localhost:8080/locatie/2
	@RequestMapping(path= "{id}", method=RequestMethod.GET)
	Optional<Locatie> getLid(@PathVariable long id) {
	return locatieService.findById(id);
	}
	
	//curl -X GET http://localhost:8080/locatie/
	@GetMapping
	public Iterable<Locatie> vindAlles() {								
		Iterable<Locatie> locaties = this.locatieService.findAll();
		return locaties;
	}
	
	//curl -X DELETE http://localhost:8080/locatie/14
	@DeleteMapping(path="{id}")
	public ResponseEntity<Locatie> apiDeleteById(@PathVariable("id") long id) {
		if (locatieService.findById(id).isPresent() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			locatieService.deleteById(id);
	return new ResponseEntity<>(HttpStatus.OK);
	}
	}
}
