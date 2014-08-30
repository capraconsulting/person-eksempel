package no.capra.person.repository;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public interface FolkeregisterRepository {
    public DSFAddress getAddress(long fnr);
}
