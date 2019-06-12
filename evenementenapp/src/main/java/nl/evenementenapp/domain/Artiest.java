package nl.evenementenapp.domain;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artiest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	private String naam;
	private String label;
	private ArrayList<String> nummers;
	private ArrayList<String> genre;
	
	public Artiest() {}
	public Artiest(String naam) {
		this.naam = naam;
	}
	
	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public ArrayList<String> getNummers() {
		return nummers;
	}

	public void setNummers(ArrayList<String> nummers) {
		this.nummers = nummers;
	}

	public ArrayList<String> getGenre() {
		return genre;
	}

	public void setGenre(ArrayList<String> genre) {
		this.genre = genre;
	}
	
	
	

}
