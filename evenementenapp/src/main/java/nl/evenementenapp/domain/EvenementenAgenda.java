package nl.evenementenapp.domain;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EvenementenAgenda {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	private String naam;
	
	public long getId() {
		return id;
	}
	
	public EvenementenAgenda() {}
	public EvenementenAgenda(String naam) {
		this.naam = naam;
	}

	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	

}
