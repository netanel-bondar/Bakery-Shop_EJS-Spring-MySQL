package org.example.demo1.controller;

import org.example.demo1.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CheckoutController {

    @Autowired
    private Cart cart;

    @Autowired
    private RepositoryUser repositoryUser;

    @Autowired
    private RepositoryOnlineDelivery repositoryOnlineDelivery;

    @Autowired
    private RepositoryFoodOrder repositoryFoodOrder;

    @GetMapping("/checkout")
    public String showCheckoutPage(Model model) {
        int total = cart.paymentSum();
        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        return "orderConfirmation";
    }

    @PostMapping("/confirm-order")
    public String completeOrder(@RequestParam String name, @RequestParam String phone,
                                @RequestParam String email, @RequestParam String city,
                                @RequestParam String street, @RequestParam String houseNumber) {

        List<FoodOrder> onlineOrders = cart.getFoodOrders();
        repositoryFoodOrder.saveAll(onlineOrders);

        // check for validation errors
        try {
            OnlineDelivery onlineDelivery = new OnlineDelivery();
            onlineDelivery.setFoodOrders(onlineOrders);
            onlineDelivery.setAddress(new Address(city, street, houseNumber));
            repositoryOnlineDelivery.save(onlineDelivery);

            User user = new User();
            user.setName(name);
            user.setPhoneNumber(phone);
            user.setOnlineDelivery(onlineDelivery);
            user.setEmail(email);
            repositoryUser.save(user);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "error";
        }

        cart.clear();
        return "orderSuccess";
    }
}
