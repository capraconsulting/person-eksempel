package no.capra.person.endpoint;

import no.capra.person.domain.Person;
import no.capra.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person get(@PathVariable String id) {
        return personRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person create(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Person update(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        personRepository.delete(id);
    }

}
