package org.example.demo1.controller;

import org.example.demo1.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MenuController {

    @Autowired
    private RepositoryFood repositoryFood;

    @Autowired
    private Cart cart;

    @GetMapping("/menu")
    public String showMenu(Model model) {
        model.addAttribute("pastries", repositoryFood.findPastries());
        model.addAttribute("breakfast", repositoryFood.findBreakfast());
        model.addAttribute("cakes", repositoryFood.findCakes());
        model.addAttribute("desserts", repositoryFood.findDesserts());

        return "menu";
    }

    @PostMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable Long id) {

        Food food = repositoryFood.findById(id).orElse(null);

        if (food == null) {
            return "error";
        }

        cart.addItem(food);

        return "redirect:/menu";
    }
}
