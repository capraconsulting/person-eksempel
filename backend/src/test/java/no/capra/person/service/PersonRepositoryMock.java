package no.capra.person.service;

import no.capra.person.domain.Person;
import no.capra.person.repository.PersonRepository;

import java.util.List;

public class PersonRepositoryMock implements PersonRepository {
    @Override
    public Person findById(String id) {
        throw new UnsupportedOperationException("Ikke implementert");
    }

    @Override
    public List<Person> findAll() {
        throw new UnsupportedOperationException("Ikke implementert");
    }

    @Override
    public Person save(Person person) {
        return person;
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Ikke implementert");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Ikke implementert");
    }
}
