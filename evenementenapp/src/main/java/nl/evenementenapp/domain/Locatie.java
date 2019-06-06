package nl.evenementenapp.domain;

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
	
	private String gebouw;
	private String Stad;
	private int staanplaatsen;
	private int zitplaatsen;
	private String website;

	public String getGebouw() {
		return gebouw;
	}
	public void setGebouw(String gebouw) {
		this.gebouw = gebouw;
	}
	public String getStad() {
		return Stad;
	}
	public void setStad(String stad) {
		Stad = stad;
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
