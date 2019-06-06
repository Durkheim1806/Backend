package nl.evenementenapp.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	private ArrayList<Evenement> evenementenBezoeken;
	
	private ArrayList<Gebruiker> vrienden;

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

	public ArrayList<Evenement> getEvenementenBezoeken() {
		return evenementenBezoeken;
	}

	public void setEvenementenBezoeken(ArrayList<Evenement> evenementenBezoeken) {
		this.evenementenBezoeken = evenementenBezoeken;
	}

	public ArrayList<Gebruiker> getVrienden() {
		return vrienden;
	}

	public void setVrienden(ArrayList<Gebruiker> vrienden) {
		this.vrienden = vrienden;
	}
	
	
}
