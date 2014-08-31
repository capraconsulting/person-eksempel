package no.capra.person.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.client.HttpClientErrorException;

public class FolkeregisterRepositoryImplRemotingTest {

    @Test
    public void shouldGetAddress() {
        Assert.assertNotNull(new FolkeregisterRepositoryImpl().getAddress(123456789012l));
    }

    @Test(expected = HttpClientErrorException.class)
    public void shouldGetErrorWhenAddressNotFound() {
        new FolkeregisterRepositoryImpl().getAddress(1l);
    }

}
