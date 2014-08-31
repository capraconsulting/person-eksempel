package no.capra.person.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class FolkeregisterRepositoryImpl implements FolkeregisterRepository {

    public FolkeregisterAddress getAddress(long fnr) {
        return new RestTemplate().getForObject("http://localhost:8080/rest/dsf/" + fnr, FolkeregisterAddress.class);
    }

}
