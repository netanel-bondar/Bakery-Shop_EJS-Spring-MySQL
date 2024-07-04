package org.example.demo1.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * this class runs as the application starts.
 * build the menu data base (food name, category and price).
 */
@Component
public class MenuInitializer implements CommandLineRunner {

    @Autowired
    private RepositoryFood repositoryFood;
    private final ArrayList<String> foodNames = new ArrayList<>();
    Map<String, Integer> priceMap = new HashMap<>();

    @Override
    public void run(String... args) {

        if (repositoryFood.count() != 0) {
            return;
        }

        foodNamesInitializer();
        priceMapInitializer();

        for (int i = 0; i < foodNames.size(); i++) {

            String category = getCategory(i);
            String foodName = foodNames.get(i);
            int price = priceMap.get(foodName);

            repositoryFood.save(new Food((long) i+1, foodName,
                    category, price));
        }
    }

    private String getCategory(int i) {

        if (i < 5) {
            return "Pastries";
        }
         if (i < 9) {
            return "Breakfast";
        }
         if (i < 13) {
            return "Cakes";
        }
         if (i < 18) {
            return "Desserts";
        }
         if (i < 21) {
            return "HotDrinks";
        }
         if (i < 23) {
            return "ColdDrinks";
        }
         if (i < 25) {
            return "SoftDrinks";
        }
         if (i < 27) {
            return "FreshJuices";
        }

        return null;
    }

    private void foodNamesInitializer() {
        foodNames.add("Butter Croissant");
        foodNames.add("Chocolate croissant");
        foodNames.add("Eclair");
        foodNames.add("Cinnamon Roll");
        foodNames.add("Tart - varies according to the season");
        foodNames.add("A Dreamy Morning Shakshuka");
        foodNames.add("Scrambled egg Croissant");
        foodNames.add("Corruption Toast");
        foodNames.add("Pancake Lighthouse");
        foodNames.add("Heart shaped chocolate cake");
        foodNames.add("Birthday cake");
        foodNames.add("Festive cheesecake");
        foodNames.add("Saint Honore cake");
        foodNames.add("Lemon Tart");
        foodNames.add("Pecan Pie");
        foodNames.add("White Chocolate Carrot Cake");
        foodNames.add("Red Volt");
        foodNames.add("A Strip of seven Macarons");
        foodNames.add("Espresso");
        foodNames.add("Americano");
        foodNames.add("Hot Chocolate");
        foodNames.add("Cold Americano");
        foodNames.add("Cold Chocolate Drink");
        foodNames.add("Water");
        foodNames.add("Soda");
        foodNames.add("Orange Juice");
        foodNames.add("Carrot Juice");
    }

    private void priceMapInitializer() {
        priceMap.put("Butter Croissant", 30);
        priceMap.put("Chocolate croissant", 31);
        priceMap.put("Eclair", 17);
        priceMap.put("Cinnamon Roll", 29);
        priceMap.put("Tart - varies according to the season", 45);
        priceMap.put("A Dreamy Morning Shakshuka", 55);
        priceMap.put("Scrambled egg Croissant", 48);
        priceMap.put("Corruption Toast", 48);
        priceMap.put("Pancake Lighthouse", 50);
        priceMap.put("Heart shaped chocolate cake", 95);
        priceMap.put("Birthday cake", 255);
        priceMap.put("Festive cheesecake", 290);
        priceMap.put("Saint Honore cake", 180);
        priceMap.put("Lemon Tart", 42);
        priceMap.put("Pecan Pie", 42);
        priceMap.put("White Chocolate Carrot Cake", 35);
        priceMap.put("Red Volt", 35);
        priceMap.put("A Strip of seven Macarons", 65);
        priceMap.put("Espresso", 9);
        priceMap.put("Americano", 12);
        priceMap.put("Hot Chocolate", 17);
        priceMap.put("Cold Americano", 15);
        priceMap.put("Cold Chocolate Drink", 13);
        priceMap.put("Water", 9);
        priceMap.put("Soda", 9);
        priceMap.put("Orange Juice", 18);
        priceMap.put("Carrot Juice", 18);
    }
}