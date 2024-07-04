package org.example.demo1.repo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * the cart which will hold for each session list of foods the user wants to make and online delivery of
 */
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

    /**
     * add a new food to the food list, if the food already in the cart, add its quantity
     */
    public void addItem(Food food) {

        for (FoodOrder foodOrder : foodOrders) {
            if (foodOrder.getFood().getId().equals(food.getId())) {
                foodOrder.setQuantity(foodOrder.getQuantity() + 1);
                return;
            }
        }

        foodOrders.add(new FoodOrder(food, 1));
    }

    /**
     * remove the food from the cart. if there are more than one of the food than decrease the quantity
     */
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

    /**
     * @return the total payment for the order
     */
    public int paymentSum() {
        int sum = 0;
        for (FoodOrder item : foodOrders) {
            sum += (item.getQuantity() * item.getFood().getPrice());
        }

        return sum;
    }
}
