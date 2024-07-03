package org.example.demo1.repo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart implements Serializable {

    private final List<FoodOrder> foodOrders = new ArrayList<>();

    /**
     * @return returns a deep copy of the {@link FoodOrder} list
     */
    public List<FoodOrder> getFoodOrders() {

        List<FoodOrder> foodOrdersCopy = new ArrayList<>();

        for (FoodOrder food : foodOrders) {
            foodOrdersCopy.add(new FoodOrder(food.getFood(), food.getQuantity()));
        }

        return foodOrdersCopy;
    }

    public void addItem(Food food) {

        for (FoodOrder foodOrder : foodOrders) {
            if (foodOrder.getFood().getId().equals(food.getId())) {
                foodOrder.setQuantity(foodOrder.getQuantity() + 1);
                return;
            }
        }

        foodOrders.add(new FoodOrder(food, 1));
    }

    public void removeItem(Food food) {
        for (FoodOrder foodOrder : foodOrders) {
            if (foodOrder.getFood().getId().equals(food.getId())) {
                foodOrder.setQuantity(foodOrder.getQuantity() - 1);
                if (foodOrder.getQuantity() == 0) {
                    foodOrders.remove(foodOrder); // Remove from list if quantity is zero
                }
                return;
            }
        }
    }

    public void clear() {
        foodOrders.clear();
    }

    public int paymentSum() {
        int sum = 0;
        for (FoodOrder item : foodOrders) {
            sum += (item.getQuantity() * item.getFood().getPrice());
        }

        return sum;
    }
}
