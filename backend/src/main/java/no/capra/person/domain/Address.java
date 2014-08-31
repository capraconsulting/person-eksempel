package no.capra.person.domain;

//@Document
public class Address {

//    @Id
//    private String id;

    private String streetname, postname, postalcode;

    public Address(String streetname, String postname, String postalcode) {
        this.streetname = streetname;
        this.postname = postname;
        this.postalcode = postalcode;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getPostname() {
        return postname;
    }

    public void setPostname(String postname) {
        this.postname = postname;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
}
