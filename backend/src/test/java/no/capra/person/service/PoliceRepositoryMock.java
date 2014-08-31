package no.capra.person.service;

import no.capra.person.repository.PoliceRepository;

public class PoliceRepositoryMock implements PoliceRepository {

    private boolean alertWasInvoked;

    @Override
    public void alert(long fnr) {
        alertWasInvoked = true;
    }

    public boolean alertWasInvoked() {
        return alertWasInvoked;
    }
}
