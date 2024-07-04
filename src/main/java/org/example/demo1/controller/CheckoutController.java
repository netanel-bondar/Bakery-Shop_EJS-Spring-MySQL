package org.example.demo1.controller;

import org.example.demo1.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * the controller which is responsible for the checkout (after the user done with adding food to the cart)\n
 * and the order confirmation page
 */
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

    /**
     * opens the checkout page with the total payment of the cart anf user details input.
     * if the cart is empty the user get send back to the menu page.
     */
    @GetMapping("/checkout")
    public String showCheckoutPage(Model model) {

        if (cart.getFoodOrders().isEmpty()) {
            return "redirect:/orders";
        }

        int total = cart.paymentSum();
        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        return "orderConfirmation";
    }

    /**
     * saves the foods array, online delivery and user to the appropriate tables,
     * empties the cart and move to the order success page.
     * if there are validation errors move to the error page.
     */
    @PostMapping("/confirm-order")
    public String completeOrder(@RequestParam String name, @RequestParam String phone,
                                @RequestParam String email, @RequestParam String city,
                                @RequestParam String street, Model model) {

        List<FoodOrder> onlineOrders = cart.getFoodOrders();

        // check for validation errors
        try {
            synchronized (RepositoryUser.class) {

                repositoryFoodOrder.saveAll(onlineOrders);

                OnlineDelivery onlineDelivery = new OnlineDelivery().setFoodOrders(onlineOrders).
                        setAddress(new Address(city, street));

                repositoryOnlineDelivery.save(onlineDelivery);

                repositoryUser.save(new User().setName(name).setPhoneNumber(phone).
                        setOnlineDelivery(onlineDelivery).setEmail(email));

                model.addAttribute("name", name);
                model.addAttribute("orderId", onlineDelivery.getId());
            }

            cart.clear();

            return "orderSuccess";
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "error";
        }
    }
}
