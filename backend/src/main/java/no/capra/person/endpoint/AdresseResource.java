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
        Long longId = Long.valueOf(id);
        if (longId < 10000000000L) {
            return new DSFAdresse("Claude Monets gate 22", "1337", "Sandvika");
        } else if (longId < 20000000000L) {
            return new DSFAdresse("Nedre Møllenbergsgate 22", "7014", "Trondheim");
        }
        return new DSFAdresse("Karl Johans gate 6", "0154", "Oslo");
    }

}
