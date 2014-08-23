package no.capra.person;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import no.capra.person.domain.Person;
import no.capra.person.repository.PersonRepository;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@ContextConfiguration(classes = ApplicationConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
public class PersonResourceIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    PersonRepository personRepository;

    @Before
    public void setup() {
        personRepository.deleteAll();
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @After
    public void etterHVerTest() {
        personRepository.deleteAll();
    }

    @Test
    public void testSkalOpprettePerson() throws Exception {
        String id = opprettPerson();
        assertNotNull(id);
    }

    @Test
    public void testSkalHentePerson() throws Exception {
        String id = opprettPerson();
        mockMvc.perform(get("/person/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id)));
    }

    @Test
    public void testSkalOppdaterePerson() throws Exception {
        String id = opprettPerson();
        Person person = new Person("Jens", "Normann");
        person.setId(id);
        mockMvc.perform(put("/person")
                .content(convertObjectToJsonBytes(person))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.firstname", is("Jens")));
    }

    @Test
    public void testSkalSlettePerson() throws Exception {
        String id = opprettPerson();
        mockMvc.perform(delete("/person/" + id))
                .andExpect(status().isOk());
        mockMvc.perform(get("/person/" + id))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    private String opprettPerson() throws Exception {
        MvcResult result = mockMvc.perform(post("/person")
                .content(convertObjectToJsonBytes(new Person("Ola", "Normann")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        return JsonPath.read(result.getResponse().getContentAsString(), "$id");
    }

    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        byte[] bytes = mapper.writeValueAsBytes(object);
        System.out.println(new String(bytes));
        return bytes;
    }

}
