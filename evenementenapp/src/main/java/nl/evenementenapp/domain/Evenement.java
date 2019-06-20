package nl.evenementenapp.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	
	private String naam;
	
	@ManyToOne
	private Locatie locatie;
	private double prijs;
	
	@OneToMany
	private Set<Artiest> artiesten;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Gebruiker> bezoekers;
	
	@ManyToOne
	private EvenementenAgenda agendaVanEvemenent;
	
	private LocalDate datum;
	private String website;
	
	@Column(length = 10000)
	private String toelichting;
	
	public Evenement() {}
	public Evenement(String naam, Locatie locatie, LocalDate datum) {
		this.naam = naam;
		this.locatie = locatie;
		this.datum = datum;
	}

	public Evenement(String naam, Locatie locatie, LocalDate datum, String website, String toelichting ) {
		this(naam, locatie, datum);
		this.toelichting = toelichting;
		this.website = website;
	}
	
	public boolean addArtiest(Artiest artiest) {
		if (artiesten == null)
			artiesten = new HashSet<>();
		return artiesten.add(artiest);
	}

	public long getId() {
		return id;
	}
	
	public EvenementenAgenda getAgendaVanEvemenent() {
		return agendaVanEvemenent;
	}
	public void setAgendaVanEvemenent(EvenementenAgenda agendaVanEvemenent) {
		this.agendaVanEvemenent = agendaVanEvemenent;
	}
	
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

	public Set<Artiest> getArtiesten() {
		return artiesten;
	}

	public void setArtiesten(Set<Artiest> artiesten) {
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
	public String getToelichting() {
		return toelichting;
	}
	public void setToelichting(String toelichting) {
		this.toelichting = toelichting;
	}
	
	

}
