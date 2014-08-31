package no.capra.person.repository;

import org.springframework.stereotype.Repository;

@Repository
public class PoliceRepositoryImpl implements PoliceRepository {
    @Override
    public void alert(long fnr) {
        // Tilkaller politiet
        System.out.println("politiet er tilkalt");
    }
}
