package nl.evenementenapp.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Locatie {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	public long getId() {
		return id;
	}
	
	private String naam;

	private String gebouw;
	private String stad;
	private int staanplaatsen;
	private int zitplaatsen;
	private String website;
	
	public Locatie() {}
	public Locatie(String naam, String stad, String website) {
		this.naam = naam;
		this.stad = stad;
		this.website = website;
	}


	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public String getGebouw() {
		return gebouw;
	}
	public void setGebouw(String gebouw) {
		this.gebouw = gebouw;
	}
	public String getStad() {
		return stad;
	}
	public void setStad(String stad) {
		this.stad = stad;
	}
	public int getStaanplaatsen() {
		return staanplaatsen;
	}
	public void setStaanplaatsen(int staanplaatsen) {
		this.staanplaatsen = staanplaatsen;
	}
	public int getZitplaatsen() {
		return zitplaatsen;
	}
	public void setZitplaatsen(int zitplaatsen) {
		this.zitplaatsen = zitplaatsen;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	

}
