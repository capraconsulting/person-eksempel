package no.capra.person.service;

import no.capra.person.repository.FolkeregisterAddress;
import no.capra.person.repository.FolkeregisterRepository;

public class FolkeregisterRepositoryMock implements FolkeregisterRepository {

    private boolean wanted;

    public FolkeregisterAddress getAddress(long fnr) {
        FolkeregisterAddress address = new FolkeregisterAddress();
        address.setGate("testgate");
        address.setPostnummer("0101");
        address.setPoststed("Oslo");
        address.setEttersoktAvPolitiet(wanted);
        return address;
    }

    public void setWanted(boolean wanted) {
        this.wanted = wanted;
    }
}
