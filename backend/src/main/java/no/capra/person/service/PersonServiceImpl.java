package no.capra.person.service;

import no.capra.person.domain.Person;
import no.capra.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person save(Person person) {
        // kall mot DSF (Det Sentrale Folkeregisteret) for å hente adresse. Tjenesten kalles slik /dsf/{fødselsnr}
        // oppdater person-objektet med adressen
        return personRepository.save(person);
    }

}
