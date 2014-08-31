package no.capra.person.endpoint;

import no.capra.person.domain.Person;
import no.capra.person.domain.remote.DSFAdresse;
import no.capra.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dsf")
public class AdresseResource {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DSFAdresse> get(@PathVariable String id) {
        Long longId = Long.valueOf(id);
        if (longId < 10000000000L) {
            return new ResponseEntity<DSFAdresse>(new DSFAdresse("Nedre Møllenbergsgt 22", "7014", "Trondheim", false), HttpStatus.OK);
        } else if (longId < 20000000000L) {
            return new ResponseEntity<DSFAdresse>(new DSFAdresse("Claude Monets gate 22", "1337", "Sandvika", true), HttpStatus.OK);
        }
        return new ResponseEntity<DSFAdresse>(new DSFAdresse("Karl Johans gate 6", "0154", "Oslo", false), HttpStatus.OK);
    }

}
