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

    @GetMapping("/menu/{isOrder}")
    public String showMenu(@PathVariable boolean isOrder, Model model) {
        model.addAttribute("pastries", repositoryFood.findPastries());
        model.addAttribute("breakfast", repositoryFood.findBreakfast());
        model.addAttribute("cakes", repositoryFood.findCakes());
        model.addAttribute("desserts", repositoryFood.findDesserts());

        model.addAttribute("isOrder", isOrder);

        return "menu";
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
}
