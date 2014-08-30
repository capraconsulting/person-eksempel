package no.capra.person.endpoint;

import no.capra.person.domain.Person;
import no.capra.person.domain.remote.DSFAdresse;
import no.capra.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dsf")
public class AdresseResource {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DSFAdresse get(@PathVariable String id) {
        return new DSFAdresse("Karl Johansgt 6", "0154", "Oslo");
    }

}
