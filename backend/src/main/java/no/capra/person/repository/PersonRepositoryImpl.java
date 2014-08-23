package no.capra.person.repository;

import no.capra.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private MongoOperations operations;

    @Override
    public Person findById(String id) {
        Assert.notNull(id, "Id kan ikke være null!");
        return operations.findById(id, Person.class);
    }

    @Override
    public List<Person> findAll() {
        return operations.findAll(Person.class);
    }

    @Override
    public Person save(Person person) {
        Assert.notNull(person, "Person kan ikke være null!");
        operations.save(person);
        return person;
    }

    @Override
    public void delete(String id) {
        Assert.notNull(id, "Id kan ikke være null!");
        operations.remove(findById(id));
    }

    @Override
    public void deleteAll() {
        operations.remove(new Query(), Person.class);
    }
}
