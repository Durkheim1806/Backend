package nl.evenementenapp.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Evenement {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	public long getId() {
		return id;
	}
	
	private String naam;
	
	@ManyToOne
	private Locatie locatie;
	private double prijs;
	
	@OneToMany
	private List<Artiest> artiesten;
	
	@ManyToMany
	private List<Gebruiker> bezoekers;
	
	private LocalDate datum;
	private String website;

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Locatie getLocatie() {
		return locatie;
	}

	public void setLocatie(Locatie locatie) {
		this.locatie = locatie;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}

	public List<Artiest> getArtiesten() {
		return artiesten;
	}

	public void setArtiesten(List<Artiest> artiesten) {
		this.artiesten = artiesten;
	}


	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<Gebruiker> getBezoekers() {
		return bezoekers;
	}

	public void setBezoekers(List<Gebruiker> bezoekers) {
		this.bezoekers = bezoekers;
	}
	
	
	

}
