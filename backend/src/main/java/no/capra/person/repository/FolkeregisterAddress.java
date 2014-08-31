package no.capra.person.repository;

public class FolkeregisterAddress {

    private String gate, postnummer, poststed;
    private boolean ettersoktAvPolitiet;

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(String postnummer) {
        this.postnummer = postnummer;
    }

    public String getPoststed() {
        return poststed;
    }

    public void setPoststed(String poststed) {
        this.poststed = poststed;
    }

    public boolean isEttersoktAvPolitiet() {
        return ettersoktAvPolitiet;
    }

    public void setEttersoktAvPolitiet(boolean ettersoktAvPolitiet) {
        this.ettersoktAvPolitiet = ettersoktAvPolitiet;
    }
}
