package no.capra.person.service;

import no.capra.person.domain.Address;
import no.capra.person.domain.Person;
import no.capra.person.repository.DSFAddress;
import no.capra.person.repository.FolkeregisterRepository;
import no.capra.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private FolkeregisterRepository folkeregisterRepository;

    @Override
    public Person save(Person person) {
        // kall mot DSF (Det Sentrale Folkeregisteret) for å hente adresse. Tjenesten kalles slik /dsf/{fødselsnr}
        // oppdater person-objektet med adressen

        DSFAddress dsfAddress = folkeregisterRepository.getAddress(person.getFnr());
        person.setAddress(new Address(
                dsfAddress.getGate(),
                dsfAddress.getPoststed(),
                dsfAddress.getPostnummer()));

        if (person.getAddress().getPostname().equals("Oslo")) {
            person.setFirstname(person.getFirstname().toUpperCase());
            person.setLastname(person.getLastname().toUpperCase());
        }

        return personRepository.save(person);
    }

    public void setFolkeregisterRepository(FolkeregisterRepository folkeregisterRepository) {
        this.folkeregisterRepository = folkeregisterRepository;
    }

    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
