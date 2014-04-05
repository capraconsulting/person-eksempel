package no.capra.person.domain;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void testSkalViseFulltNavn() {
        Person person = new Person("Morten", "Tangen");
        Assert.assertEquals("Morten Tangen", person.getFulltNavn());
    }

}
