package no.capra.person.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document
@JsonIgnoreProperties(ignoreUnknown=true)
public class Person implements Serializable {

    @Id
    private String id;
    private String firstname, lastname;
    private long fnr;

//    @DBRef
    private Address address;

    public Person() {
    }

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getFnr() {
        return fnr;
    }

    public void setFnr(long fnr) {
        this.fnr = fnr;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Transient
    public String getFulltNavn() {
        return firstname + " " + lastname;
    }
}
