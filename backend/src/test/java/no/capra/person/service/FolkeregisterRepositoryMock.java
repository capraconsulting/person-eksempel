package no.capra.person.service;

import no.capra.person.repository.DSFAddress;
import no.capra.person.repository.FolkeregisterRepository;

public class FolkeregisterRepositoryMock implements FolkeregisterRepository {

    private boolean osloResident;

    public DSFAddress getAddress(long fnr) {
        DSFAddress address = new DSFAddress();
        address.setGate("testgate");
        address.setPostnummer("0101");
        address.setPoststed(osloResident ? "Oslo" : "Tønsberg");
        return address;
    }

    public void setOsloResident(boolean osloResident) {
        this.osloResident = osloResident;
    }
}
