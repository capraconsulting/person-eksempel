package no.capra.person.repository;

import no.capra.person.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByLastname(@Param("lastname") String lastname);

}
