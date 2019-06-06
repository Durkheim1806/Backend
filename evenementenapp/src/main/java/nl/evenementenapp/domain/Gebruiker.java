package nl.evenementenapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
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
	
	@ManyToMany
	private List<Evenement> evenementenBezoeken;
	
	@OneToMany
	private List<Gebruiker> vrienden;

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

	public List<Evenement> getEvenementenBezoeken() {
		return evenementenBezoeken;
	}

	public void setEvenementenBezoeken(List<Evenement> evenementenBezoeken) {
		this.evenementenBezoeken = evenementenBezoeken;
	}

	public List<Gebruiker> getVrienden() {
		return vrienden;
	}

	public void setVrienden(List<Gebruiker> vrienden) {
		this.vrienden = vrienden;
	}

	
	
	
}
