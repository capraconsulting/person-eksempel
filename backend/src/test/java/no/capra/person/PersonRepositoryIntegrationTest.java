package no.capra.person;

import org.junit.*;
import no.capra.person.domain.Person;
import no.capra.person.repository.PersonRepository;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsNull;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@ActiveProfiles("test")
public class PersonRepositoryIntegrationTest {

    @Autowired
    PersonRepository personRepository;

    @Before
    public void beforeEachTest() {
        personRepository.deleteAll();
    }

    @After
    public void afterAllTests() {
        personRepository.deleteAll();
    }

    @Test
    public void testSkalOpprettePersonIMongoRepo() {
        Person person = personRepository.save(new Person("test", "testersen"));
        Assert.assertNotNull(person.getId());
        Assert.assertEquals(1, personRepository.count());
    }



}
