package nl.evenementenapp.endpoint;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import nl.evenementenapp.service.ArtiestService;

@RestController
@RequestMapping(path = "artiest") // hier mag je ook value = zetten, of de path = helemaal weglaten
public class ArtiestEndPoint {
	@Autowired
	ArtiestService artiestService;

	@PostMapping
	public ResponseEntity<Artiest> aanmaken(@RequestBody Artiest a) { 
		if (a.getId() != 0) {
			return new ResponseEntity<> (HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Artiest>(artiestService.save(a), HttpStatus.OK); 
	}
	
	//curl -X GET http://localhost:8080/artiest/query?name=Z
	@RequestMapping(value="query", method=RequestMethod.GET)  
	public Iterable<Artiest> selectieOpvragen(@RequestParam(
			required=false, defaultValue="A") String name ) {
		return artiestService.findByNaam(name);
	}
	
	//curl -X GET http://localhost:8080/artiest/2
	@RequestMapping(path= "{id}", method=RequestMethod.GET)
	Optional<Artiest> getLid(@PathVariable long id) {
	return artiestService.findById(id);
	}
	
	//curl -X GET http://localhost:8080/artiest/
	@GetMapping
	public Iterable<Artiest> vindAlles() {								// ik heb hem public gemaakt, Stef niet..
		Iterable<Artiest> artiesten = this.artiestService.findAll();
		return artiesten;
	}
	
	//curl -X DELETE http://localhost:8080/artiest/14
	@DeleteMapping(path="{id}")
	public ResponseEntity<Artiest> apiDeleteById(@PathVariable("id") long id) {
		if (artiestService.findById(id).isPresent() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			artiestService.deleteById(id);
	return new ResponseEntity<>(HttpStatus.OK);
	}
	}
}
	