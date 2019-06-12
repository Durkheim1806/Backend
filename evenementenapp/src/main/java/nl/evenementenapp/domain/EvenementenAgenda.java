package nl.evenementenapp.domain;

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
	
	
	ArrayList<Evenement> geregistreerdeEvenementen;
	
	ArrayList<Locatie> geregistreerdeLocaties;
	
	ArrayList<Gebruiker> geregistreerdeGebruikers;

	ArrayList<Artiest> geregistreerdeArtiesten;
	
	

	public ArrayList<Evenement> getGeregistreerdeEvenementen() {
		return geregistreerdeEvenementen;
	}
	public void setGeregistreerdeEvenementen(ArrayList<Evenement> geregistreerdeEvenementen) {
		this.geregistreerdeEvenementen = geregistreerdeEvenementen;
	}
	public ArrayList<Locatie> getGeregistreerdeLocaties() {
		return geregistreerdeLocaties;
	}
	public void setGeregistreerdeLocaties(ArrayList<Locatie> geregistreerdeLocaties) {
		this.geregistreerdeLocaties = geregistreerdeLocaties;
	}
	public ArrayList<Gebruiker> getGeregistreerdeGebruikers() {
		return geregistreerdeGebruikers;
	}
	public void setGeregistreerdeGebruikers(ArrayList<Gebruiker> geregistreerdeGebruikers) {
		this.geregistreerdeGebruikers = geregistreerdeGebruikers;
	}
	public ArrayList<Artiest> getGeregistreerdeArtiesten() {
		return geregistreerdeArtiesten;
	}
	public void setGeregistreerdeArtiesten(ArrayList<Artiest> geregistreerdeArtiesten) {
		this.geregistreerdeArtiesten = geregistreerdeArtiesten;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	

}
