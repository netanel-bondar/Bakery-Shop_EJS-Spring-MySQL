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
    private String city, street, houseNumber;

    public Address() {}

    public Address(String city, String street, String houseNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
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

    public void setHouseNumber(String houseNumber) {

        checkString(houseNumber);
        this.houseNumber = houseNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void checkAddress() {
        checkString(this.city);
        checkString(this.street);
        checkString(this.houseNumber);
    }

    private void checkString(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("city, street and house number are required");
        }
    }

    @Override
    public String toString() {
        return "address [city=" + this.city + ", street=" + this.street + ", houseNumber=" + this.houseNumber + "]";
    }
}
