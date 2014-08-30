package no.capra.person.domain.remote;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DSFAdresse {

    private String gate, postnummer, poststed;

    public DSFAdresse(String gate, String postnummer, String poststed) {
        this.gate = gate;
        this.postnummer = postnummer;
        this.poststed = poststed;
    }

    public String getGate() {
        return gate;
    }

    public String getPostnummer() {
        return postnummer;
    }

    public String getPoststed() {
        return poststed;
    }
}
