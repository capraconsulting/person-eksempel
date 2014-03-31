package no.capra.person.endpoint;

import no.capra.person.domain.Person;
import no.capra.person.repository.PersonRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Path("/person")
@Component
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person get(@PathParam("id") String id) {
        return personRepository.findOne(id);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> list() {
        return personRepository.findAll();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id) {
        personRepository.delete(id);
    }

}
