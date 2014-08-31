package no.capra.person.domain.remote;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DSFAdresse {

    private String gate, postnummer, poststed;
    private boolean ettersoktAvPolitiet;

    public DSFAdresse() {
        gate = postnummer = poststed = "";
    }

    public DSFAdresse(String gate, String postnummer, String poststed, boolean ettersoktAvPolitiet) {
        this.gate = gate;
        this.postnummer = postnummer;
        this.poststed = poststed;
        this.ettersoktAvPolitiet = ettersoktAvPolitiet;
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

    public boolean isEttersoktAvPolitiet() {
        return ettersoktAvPolitiet;
    }
}
