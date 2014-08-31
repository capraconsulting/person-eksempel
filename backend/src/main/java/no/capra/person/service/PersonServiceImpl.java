package no.capra.person.service;

import no.capra.person.domain.Address;
import no.capra.person.domain.Person;
import no.capra.person.repository.FolkeregisterAddress;
import no.capra.person.repository.FolkeregisterRepository;
import no.capra.person.repository.PersonRepository;
import no.capra.person.repository.PoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private FolkeregisterRepository folkeregisterRepository;

    @Autowired
    private PoliceService policeService;

    /**
     * Oppgave 1:
     * Lag oppslag mot Folkeregisteret ved å bruke RestTemplate.java. URL blir gitt ut av Morten
     * http://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html
     *
     * Oppgave 2:
     * Dersom personen er etterlyst, kall PoliceService.alert(...) og returner personobjektet uten å oppdatere adressen (litt snålt, men gjør det for eksempelets skyld)
     * Dersom personen ikke er etterlyst, oppdater personen med adressen og kall personRepository.save(person)
     *
     * Oppgave 3:
     * Lag følgende tester:
     * - shouldAlertPoliceIfPersonIsWanted
     * - sholdNotAlertPoliceIfPersonIsNotWanted
     * - shouldSavePersonIfPersonIsNotWanted
     * - shouldNotSavePersonIfPersonIsWanted
     * - shouldSetAddressIfPersonIsNotWanted
     * - shouldNotSetAddressIfPersonIsWanted
     */
    @Override
    public Person save(Person person) {
        // kall mot DSF (Det Sentrale Folkeregisteret) for å hente adresse. Tjenesten kalles slik /dsf/{fødselsnr}
        // oppdater person-objektet med adressen dersom personen bor i Norge

        FolkeregisterAddress folkeregisterAddress = folkeregisterRepository.getAddress(person.getFnr());
        if (folkeregisterAddress.isEttersoktAvPolitiet()) {
            policeService.alert(person.getFnr());
            return person;
        } else {
            person.setAddress(new Address(
                    folkeregisterAddress.getGate(),
                    folkeregisterAddress.getPoststed(),
                    folkeregisterAddress.getPostnummer()));
            return personRepository.save(person);
        }
    }

    private boolean addressFound(FolkeregisterAddress folkeregisterAddress) {
        return !(folkeregisterAddress.getGate().isEmpty() && folkeregisterAddress.getPostnummer().isEmpty() && folkeregisterAddress.getPoststed().isEmpty());
    }

    public void setFolkeregisterRepository(FolkeregisterRepository folkeregisterRepository) {
        this.folkeregisterRepository = folkeregisterRepository;
    }

    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void setPoliceService(PoliceService policeService) {
        this.policeService = policeService;
    }
}
