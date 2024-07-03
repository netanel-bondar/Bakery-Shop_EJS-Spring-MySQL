package org.example.demo1.repo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Holds city, street name and house number
 */
@Entity
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private String city, street;

    public Address() {}

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public void setCity(String city) {

        checkString(city);
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setStreet(String street) {

        checkString(street);
        this.street = street;
    }

    public String getStreet() {
        return street;
    }


    public void checkAddress() {
        checkString(this.city);
        checkString(this.street);
    }

    private void checkString(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("city, street and house number are required");
        }
    }

    @Override
    public String toString() {
        return "address [city=" + this.city + ", street=" + this.street + "]";
    }
}
