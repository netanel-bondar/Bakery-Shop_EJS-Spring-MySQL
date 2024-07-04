package org.example.demo1.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

//        if (repositoryFood.count() == 0) {
//            repositoryFood.save(new Food(1L,"Butter Croissant", "Pastries", 30));
//            repositoryFood.save(new Food(2L,"Chocolate croissant", "Pastries", 31));
//            repositoryFood.save(new Food(3L,"Eclair", "Pastries",17));
//            repositoryFood.save(new Food(4L,"Cinnamon Roll", "Pastries",29));
//            repositoryFood.save(new Food(5L,"Tart - varies according to the season", "Pastries",45));
//            repositoryFood.save(new Food(6L,"A Dreamy Morning Shakshuka", "Breakfast",55));
//            repositoryFood.save(new Food(7L,"Scrambled egg Croissant", "Breakfast",48));
//            repositoryFood.save(new Food(8L,"Corruption Toast", "Breakfast",48));
//            repositoryFood.save(new Food(9L,"Pancake Lighthouse", "Breakfast",50));
//            repositoryFood.save(new Food(10L,"Heart shaped chocolate cake", "Cakes",95));
//            repositoryFood.save(new Food(11L,"Birthday cake", "Cakes",255));
//            repositoryFood.save(new Food(12L,"Festive cheesecake", "Cakes",290));
//            repositoryFood.save(new Food(13L,"Saint Honore cake", "Cakes",180));
//            repositoryFood.save(new Food(14L,"Lemon Tart", "Desserts",42));
//            repositoryFood.save(new Food(15L,"Pecan Pie", "Desserts",42));
//            repositoryFood.save(new Food(16L,"White Chocolate Carrot Cake", "Desserts",35));
//            repositoryFood.save(new Food(17L,"Red Volt", "Desserts",35));
//            repositoryFood.save(new Food(18L,"A Strip of seven Macarons", "Desserts",65));
//            repositoryFood.save(new Food(19L,"Espresso", "HotDrinks",9));
//            repositoryFood.save(new Food(20L,"Americano", "HotDrinks",12));
//            repositoryFood.save(new Food(21L,"Hot Chocolate", "HotDrinks",17));
//            repositoryFood.save(new Food(22L,"Cold Americano", "ColdDrinks",15));
//            repositoryFood.save(new Food(23L,"Cold Chocolate Drink", "ColdDrinks",13));
//            repositoryFood.save(new Food(24L,"Water", "SoftDrinks",9));
//            repositoryFood.save(new Food(25L,"Soda", "SoftDrinks",9));
//            repositoryFood.save(new Food(26L,"Orange Juice", "FreshJuices",18));
//            repositoryFood.save(new Food(27L,"Carrot Juice", "FreshJuices",18));
//        }
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