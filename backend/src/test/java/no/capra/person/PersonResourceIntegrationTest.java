package no.capra.person;

import com.fasterxml.classmate.GenericType;
import no.capra.person.domain.Person;
import no.capra.person.endpoint.PersonResource;
import no.capra.person.repository.PersonRepository;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PersonResourceIntegrationTest extends JerseyTest {

    PersonRepository personRepository;

    @Override
    protected Application configure() {
        System.setProperty("spring.profiles.default", "test");
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        personRepository = context.getBean(PersonRepository.class);
        return new JerseyConfig().property("contextConfig", context);
    }

    @Before
    public void setup() {
        personRepository.deleteAll();
    }

    @Test
    public void smokeTest() {
        Response response = target("person").request().post(Entity.json(new Person("Ola", "Normann")));
        Person personSaved = response.readEntity(Person.class);
        Person person = target("person").path(personSaved.getId()).request().get(Person.class);
        assertEquals("Ola", person.getFirstname());
        assertEquals("Normann", person.getLastname());

        target("person").path(personSaved.getId()).request().delete();
        List personListe = target("person").request().get(List.class);
        assertEquals(0, personListe.size());
    }

}
