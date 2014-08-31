package no.capra.person.repository;

public class PoliceServiceImpl implements PoliceService {
    @Override
    public void alert(long fnr) {
        // Tilkaller politiet
        System.out.println("politiet er tilkalt");
    }
}
