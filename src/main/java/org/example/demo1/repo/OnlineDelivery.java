package org.example.demo1.repo;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class OnlineDelivery implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<FoodOrder> foodOrders;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public Long getId() {
        return id;
    }

    public OnlineDelivery setId(Long id) {

        this.id = id;
        return this;
    }

    public List<FoodOrder> getFoodOrders() {
        return foodOrders;
    }

    public OnlineDelivery setFoodOrders(List<FoodOrder> foodOrders) {

        this.foodOrders = foodOrders;
        return this;
    }

    public Address getAddress() {
        return address;
    }
    public OnlineDelivery setAddress(Address address) {

        this.address = address;
        return this;
    }
}
