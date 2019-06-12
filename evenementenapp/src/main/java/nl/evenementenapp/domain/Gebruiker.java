package nl.evenementenapp.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Gebruiker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	public long getId() {
		return id;
	}
	
	private String naam;
	private String gebruikersnaam;
	private String wachtwoord;
	private LocalDate geboortedatum;
	private String woonplaats;
	
	@ManyToMany
	private Set<Evenement> evenementenBezoeken;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	private Set<Auto> autos = new HashSet<>();
	
	@OneToMany
	private List<Gebruiker> vrienden;
	
	public Gebruiker() {}
	public Gebruiker(String naam, String woonplaats, LocalDate geboortedatum) {
		this.naam = naam;
		this.woonplaats = woonplaats;
		this.geboortedatum = geboortedatum;
	}
	
	public boolean addEvenement(Evenement evenement) {
		if (evenementenBezoeken == null)
			evenementenBezoeken = new HashSet<>();
		return evenementenBezoeken.add(evenement);
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public Set<Evenement> getEvenementenBezoeken() {
		return evenementenBezoeken;
	}

	public void setEvenementenBezoeken(Set<Evenement> evenementenBezoeken) {
		this.evenementenBezoeken = evenementenBezoeken;
	}

	public List<Gebruiker> getVrienden() {
		return vrienden;
	}

	public void setVrienden(List<Gebruiker> vrienden) {
		this.vrienden = vrienden;
	}

	
	
	
}
