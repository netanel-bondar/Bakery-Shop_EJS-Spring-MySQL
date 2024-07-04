package org.example.demo1.repo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    @Email
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private OnlineDelivery onlineDelivery;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public User setId(Long id) {

        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {

        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
        return this;
    }

    public OnlineDelivery getOnlineDelivery() {
        return onlineDelivery;
    }
    public User setOnlineDelivery(OnlineDelivery onlineDelivery) {

        this.onlineDelivery = onlineDelivery;
        return this;
    }
    public String getEmail() {
        return email;
    }
    public User setEmail(String email) {

        this.email = email;
        return this;
    }
}