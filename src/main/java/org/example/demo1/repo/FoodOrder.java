package org.example.demo1.repo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;

/**
 * holds a food item from the menu and its quantity
 */
@Entity
public class FoodOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Food food;

    @Positive
    private int quantity;

    public FoodOrder() {}

    public FoodOrder(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "FoodOrder [id=" + id + ", food=" + food + ", quantity=" + quantity + "]";
    }
}
