package nl.evenementenapp.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nl.evenementenapp.domain.Artiest;
import nl.evenementenapp.service.ArtiestService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("artiesten")
public class ArtiestEndPoint {
	@Autowired
	ArtiestService artiestService;
	
	@GetMapping
	public Iterable<Artiest> findAll() {
		Iterable<Artiest> artiesten = this.artiestService.findAll();
		return artiesten;
	}
	
	@PostMapping
	public Artiest create(@RequestBody Artiest a) { // @RequestBody
		
		return artiestService.save(a); 
	}

	
	
//	
//	Iterable<Artiest> getSelection(@RequestParam(
//			required=false, defaultValue="A") String name) {
//		return artiestService.findByNaam(name);
//	}
			
	
	

}
