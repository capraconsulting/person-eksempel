package no.capra.person.repository;

import no.capra.person.domain.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonRepository {

    Person findById(String id);

    List<Person> findAll();

    Person save(Person person);

    void delete(String id);

    void deleteAll();

}
