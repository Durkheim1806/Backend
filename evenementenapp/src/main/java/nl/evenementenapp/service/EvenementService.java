package nl.evenementenapp.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.evenementenapp.domain.Artiest;
import nl.evenementenapp.domain.Evenement;
import nl.evenementenapp.domain.EvenementenAgenda;
import nl.evenementenapp.domain.Gebruiker;
import nl.evenementenapp.domain.Locatie;
import nl.evenementenapp.repository.EvenementRepository;

@Service
@Transactional
public class EvenementService {

	@Autowired
	EvenementRepository evenementRepository;	
	@Autowired
	EvenementService evenementService;
	@Autowired 
	GebruikerService gebruikerService;
	@Autowired
	LocatieService locatieService;
	@Autowired
	EvenementenAgendaService evenementenAgendaService;
	@Autowired
	ArtiestService artiestService;
	
	public Evenement save(Evenement evenement) {
		return evenementRepository.save(evenement);
	}
	
	public Optional<Evenement> findById(long id) {
		return evenementRepository.findById(id);
	}
	
	public Iterable<Evenement> findAll() {
		return evenementRepository.findAll();
	}

	public void deleteById(long id) {
		evenementRepository.deleteById(id);
	}
	
	public Iterable<Evenement> findByNaam(String name) {
		return evenementRepository.findByNaamContainingOrderByNaam(name);
	}
	
	@PostConstruct 
	void initEvenementDatabase() {
		
		if (evenementRepository.count()!=0) return;

		Locatie locatie = locatieService.save(new Locatie("AFAS Live", "Amsterdam", "http://afaslive.nl"));
		Locatie locatie2 = locatieService.save(new Locatie("Nelson Mandelapark", "Amsterdam", "n.v.t."));
		Locatie locatie3 = locatieService.save(new Locatie("Het Twiske", "Amsterdam", "https://www.iamsterdam.com/nl/zien-en-doen/natuur/natuurgebieden/recreatiegebied-het-twiske"));
		
		Evenement strayCats = evenementRepository.save(new Evenement("Stray Cats", locatie, LocalDate.of(2019, 7, 1),			
				"Voor het eerst in tien jaar komen de leden van de Amerikaanse rockabillyband Stray Cats weer bij elkaar. "
				+ "Gitarist-zanger Brian Setzer, bassist Lee Rocker en drummer Slim Jim Phantom zullen 1 juli voor een éénmalige "
				+ "show afreizen naar AFAS Live." ));
		Evenement kwaku = evenementRepository.save(new Evenement("Kwaku Summer Festival", locatie2, LocalDate.of(2019, 7, 14),	
				"Kwakoe begon in 1975 als kleinschalig voetbaltoernooi om de jeugd in de Bijlmermeer die niet op vakantie kon "
				+ "gaan toch een leuke zomer te bezorgen. Al snel groeide Kwakoe uit tot een competitie waar niet alleen "
				+ "gevoetbald werd, maar waar eten en drinken een belangrijke plaats innam. Tegenwoordig staat het festival "
				+ "vooral bekend om de sfeer en zijn er naast het voetbal tal van andere activiteiten zoals debatten, lezingen,"
				+ " dansworkshops, missverkiezingen en muziekoptredens."));
		Evenement welcome = evenementRepository.save(new Evenement("Welcome to the future", locatie3, LocalDate.of(2019, 7, 20),			
				"Welcome to the Future is een intiem en gemoedelijk festival. Kleine hoekjes met hangmatten en schommels zorgen "
				+ "voor verkoeling en aan het water kun je heerlijk zitten of genieten van biologische burgers, vers fruit of mojito’s. "
				+ "Op 8 verschillende podia staan nationale en internationale dj's voor je klaar. Of je nu een technokonijn, een hipster "
				+ "of houseliefhebber bent, iedereen is welkom!"));
				
		Gebruiker fred = gebruikerService.save(new Gebruiker("Fred Teeven", "Amsterdam", LocalDate.of(1968, 8, 5)));
		Gebruiker spinoza = gebruikerService.save(new Gebruiker("Baruch Spinoza", "Amsterdam", LocalDate.of(1632, 11, 24)));
		Gebruiker obama = gebruikerService.save(new Gebruiker("Barack Obama", "Washington DC", LocalDate.of(1961, 8, 04)));
		
		Artiest stray = artiestService.save(new Artiest("Stray Cats"));
		Artiest jocelyn = artiestService.save(new Artiest("Jocelyn Brown"));
		Artiest benny = artiestService.save(new Artiest("Benny Rodrigues"));
		
		fred.addEvenement(kwaku);
		spinoza.addEvenement(strayCats);
		obama.addEvenement(welcome);
		obama.addEvenement(strayCats);
		gebruikerService.save(fred);
		gebruikerService.save(spinoza);
		gebruikerService.save(obama);
		
		strayCats.addArtiest(stray);
		kwaku.addArtiest(jocelyn);
		welcome.addArtiest(benny);
		evenementService.save(strayCats);
		evenementService.save(kwaku);
		evenementService.save(welcome);
		
		EvenementenAgenda agendaMei = evenementenAgendaService.save(new EvenementenAgenda("Agenda van juli 2019"));
		
		// is de evenementenagenda nog wel nodig?
	}
}
