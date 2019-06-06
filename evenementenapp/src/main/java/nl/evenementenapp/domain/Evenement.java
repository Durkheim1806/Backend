package nl.evenementenapp.domain;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	private Locatie locatie;
	private double prijs;
	
	@OneToMany
	private ArrayList<Artiest> artiesten;
	
	@ManyToMany
	private ArrayList<Gebruiker> bezoekers;
	
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

	public ArrayList<Artiest> getArtiesten() {
		return artiesten;
	}

	public void setArtiesten(ArrayList<Artiest> artiesten) {
		this.artiesten = artiesten;
	}

	public ArrayList<Gebruiker> getBezoekers() {
		return bezoekers;
	}

	public void setBezoekers(ArrayList<Gebruiker> bezoekers) {
		this.bezoekers = bezoekers;
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
	
	
	

}
