package no.capra.person.repository;

import org.springframework.stereotype.Repository;

@Repository
public class PoliceRepositoryImpl implements PoliceRepository {
    @Override
    public void alert(String fnr) {
        System.out.println("Politiet er advart");
    }
}
