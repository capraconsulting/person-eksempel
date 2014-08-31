package no.capra.person.service;

import no.capra.person.domain.Address;
import no.capra.person.domain.Person;
import no.capra.person.repository.FolkeregisterRepository;
import no.capra.person.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonServiceImplTest {

    PersonServiceImpl personService;
    FolkeregisterRepositoryMock folkeregisterRepositoryMock;
    PersonRepositoryMock personRepositoryMock;
    PoliceServiceMock policeServiceMock;
    Person person;

    @Before
    public void setup() {
        folkeregisterRepositoryMock = new FolkeregisterRepositoryMock();
        personRepositoryMock = new PersonRepositoryMock();
        policeServiceMock = new PoliceServiceMock();

        personService = new PersonServiceImpl();
        personService.setFolkeregisterRepository(folkeregisterRepositoryMock);
        personService.setPersonRepository(personRepositoryMock);
        personService.setPoliceService(policeServiceMock);

        person = new Person("Ola", "Normann");
        person.setFnr(31057831777l);
    }

    @Test
    public void shouldAlertPoliceIfPersonIsWanted() {
        folkeregisterRepositoryMock.setWanted(true);

        Person savedPerson = personService.save(person);

        assertTrue(policeServiceMock.alertWasInvoked());
    }

    @Test
    public void shouldNotAlertPoliceIfPersonIsNotWanted() {
        folkeregisterRepositoryMock.setWanted(false);

        Person savedPerson = personService.save(person);

        assertFalse(policeServiceMock.alertWasInvoked());
    }

    @Test
    public void shouldSavePersonIfPersonIsNotWanted() {
        folkeregisterRepositoryMock.setWanted(false);

        Person savedPerson = personService.save(person);

        assertTrue(personRepositoryMock.saveWasInvoked());
    }

    @Test
    public void shouldNotSavePersonIfPersonIsWanted() {
        folkeregisterRepositoryMock.setWanted(true);

        Person savedPerson = personService.save(person);

        assertFalse(personRepositoryMock.saveWasInvoked());
    }

    @Test
    public void shouldSetAddressIfPersonIsNotWanted() {
        folkeregisterRepositoryMock.setWanted(false);

        Person savedPerson = personService.save(person);

        assertNotNull(savedPerson.getAddress());
    }

    @Test
    public void shouldNotSetAddressIfPersonIsWanted() {
        folkeregisterRepositoryMock.setWanted(true);

        Person savedPerson = personService.save(person);

        assertNull(savedPerson.getAddress());
    }
}
