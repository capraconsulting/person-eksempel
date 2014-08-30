package no.capra.person.service;

import no.capra.person.domain.Person;
import no.capra.person.repository.FolkeregisterRepository;
import no.capra.person.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonServiceImplTest {

    PersonServiceImpl personService;
    FolkeregisterRepositoryMock folkeregisterRepositoryMock;

    @Before
    public void setup() {
        folkeregisterRepositoryMock = new FolkeregisterRepositoryMock();
        PersonRepository personRepositoryMock = new PersonRepositoryMock();

        personService = new PersonServiceImpl();
        personService.setFolkeregisterRepository(folkeregisterRepositoryMock);
        personService.setPersonRepository(personRepositoryMock);
    }

    @Test
    public void shouldCapitalizeFirstnameAndLastnameForOsloResidents() throws Exception {
        folkeregisterRepositoryMock.setOsloResident(true);
        Person person = new Person("Ola", "Normann");
        person.setFnr(31057831777l);
        Person savedPerson = personService.save(person);
        Assert.assertEquals("OLA", savedPerson.getFirstname());
        Assert.assertEquals("NORMANN", savedPerson.getLastname());
    }

    @Test
    public void shouldNotCapitalizeFirstnameAndLastnameForNonOsloResidents() throws Exception {
        folkeregisterRepositoryMock.setOsloResident(false);
        Person person = new Person("Ola", "Normann");
        person.setFnr(31057831777l);
        Person savedPerson = personService.save(person);
        Assert.assertEquals("Ola", savedPerson.getFirstname());
        Assert.assertEquals("Normann", savedPerson.getLastname());
    }

}
