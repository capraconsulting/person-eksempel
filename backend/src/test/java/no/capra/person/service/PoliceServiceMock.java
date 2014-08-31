package no.capra.person.service;

import no.capra.person.repository.PoliceService;

public class PoliceServiceMock implements PoliceService {

    private boolean alertWasInvoked;

    @Override
    public void alert(long fnr) {
        alertWasInvoked = true;
    }

    public boolean alertWasInvoked() {
        return alertWasInvoked;
    }
}
