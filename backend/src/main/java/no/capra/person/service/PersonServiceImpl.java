package no.capra.person.service;

import no.capra.person.domain.Person;
import no.capra.person.repository.PersonRepository;
import no.capra.person.repository.PoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    
    /**
     * Oppgave 1:
     * Lag oppslag mot Folkeregisteret fra ny klasse, FolkeregisterRepository, ved å bruke RestTemplate.java. URL blir gitt ut av Morten.
     * Lag en test, FolkeregisterRepositoryTest, som verifiserer oppslag og uthenting av adressen.
     * http://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html
     *
     * Oppgave 2:
     * Dersom personen er etterlyst, kall PoliceRepository.alert(...) og returner personobjektet uten å oppdatere adressen (litt snålt, men gjør det for eksempelets skyld)
     * Dersom personen ikke er etterlyst, oppdater personen med adressen og kall personRepository.save(person)
     *
     * Oppgave 3:
     * Fyll ut testene i PersonServiceImplTest.java
     */
    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

}
