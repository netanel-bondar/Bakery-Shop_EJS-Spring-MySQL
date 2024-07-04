package org.example.demo1.controller;

import org.example.demo1.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * controller which is responsible for the menu actions.
 * shows the menu with the buttons that add the food to the cart.
 */
@Controller
public class MenuController {

    @Autowired
    private RepositoryFood repositoryFood;

    @Autowired
    private Cart cart;

    /**
    * shows the menu without the option to add to cart
     */
    @GetMapping("/menu")
    public String showMenu(Model model) {

        setMenuAttributes(model);

        model.addAttribute("isOrder", false);

        return "menu";
    }

    /**
    * shows the menu with the option to add to cart
     */
    @GetMapping("/orders")
    public String showMenuOrders(Model model) {

        setMenuAttributes(model);

        model.addAttribute("cart", cart);

        model.addAttribute("foodOrders", cart.getFoodOrders());
        model.addAttribute("isCartEmpty", cart.getFoodOrders().isEmpty());

        model.addAttribute("isOrder", true);

        return "menu";
    }

    private void setMenuAttributes(Model model) {
        model.addAttribute("pastries", repositoryFood.findPastries());
        model.addAttribute("breakfast", repositoryFood.findBreakfast());
        model.addAttribute("cakes", repositoryFood.findCakes());
        model.addAttribute("desserts", repositoryFood.findDesserts());
        model.addAttribute("hotdrinks", repositoryFood.findHotDrinks());
        model.addAttribute("colddrinks", repositoryFood.findColdDrinks());
        model.addAttribute("softdrinks", repositoryFood.findSoftDrinks());
        model.addAttribute("freshjuices", repositoryFood.findFreshJuices());
    }

    @PostMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable Long id, Model model) {

        Food food = repositoryFood.findById(id).orElse(null);

        if (food == null) {
            return "error";
        }

        cart.addItem(food);

        model.addAttribute("isOrder", true);

        return "menu";
    }

    @PostMapping("/decrease-from-cart/{id}")
    public String decreaseFromCart(@PathVariable Long id, Model model) {

        Food food = repositoryFood.findById(id).orElse(null);

        if (food == null) {
            return "error";
        }

        cart.removeItem(food);

        model.addAttribute("isOrder", true);

        return "menu";
    }
}
