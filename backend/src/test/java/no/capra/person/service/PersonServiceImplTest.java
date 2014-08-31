package no.capra.person.service;

import org.junit.Before;
import org.junit.Test;

public class PersonServiceImplTest {

    PersonServiceImpl personService;

    @Before
    public void setup() {
        // alt felles oppsett for testene legges inn her
        personService = new PersonServiceImpl();
    }

    @Test
    public void shouldAlertPoliceIfPersonIsWanted() {
        // oppsett for denne testen

        // kall metoden under test

        // verifiser forventet oppførsel
    }

    @Test
    public void shouldNotAlertPoliceIfPersonIsNotWanted() {
    }

    @Test
    public void shouldSavePersonIfPersonIsNotWanted() {
    }

    @Test
    public void shouldNotSavePersonIfPersonIsWanted() {
    }

    @Test
    public void shouldSetAddressIfPersonIsNotWanted() {
    }

    @Test
    public void shouldNotSetAddressIfPersonIsWanted() {
    }
}
