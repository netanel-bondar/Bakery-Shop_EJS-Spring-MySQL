package org.example.demo1.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MenuInitializer implements CommandLineRunner {

    @Autowired
    private RepositoryFood repositoryFood;

    @Override
    public void run(String... args) throws Exception {
        if (repositoryFood.count() == 0) {
            repositoryFood.save(new Food(1L,"Butter Croissant", "Pastries", 30));
            repositoryFood.save(new Food(2L,"Chocolate croissant", "Pastries", 31));
            repositoryFood.save(new Food(3L,"Eclair", "Pastries",17));
            repositoryFood.save(new Food(4L,"Cinnamon Roll", "Pastries",29));
            repositoryFood.save(new Food(5L,"Tart - varies according to the season", "Pastries",45));
            repositoryFood.save(new Food(6L,"A Dreamy Morning Shakshuka", "Breakfast",55));
            repositoryFood.save(new Food(7L,"Scrambled egg Croissant", "Breakfast",48));
            repositoryFood.save(new Food(8L,"Corruption Toast", "Breakfast",48));
            repositoryFood.save(new Food(9L,"Pancake Lighthouse", "Breakfast",50));
            repositoryFood.save(new Food(10L,"Heart shaped chocolate cake", "Cakes",95));
            repositoryFood.save(new Food(11L,"Birthday cake", "Cakes",255));
            repositoryFood.save(new Food(12L,"Festive cheesecake", "Cakes",290));
            repositoryFood.save(new Food(13L,"Saint Honore cake", "Cakes",180));
            repositoryFood.save(new Food(14L,"Lemon Tart", "Desserts",42));
            repositoryFood.save(new Food(15L,"Pecan Pie", "Desserts",42));
            repositoryFood.save(new Food(16L,"White Chocolate Carrot Cake", "Desserts",35));
            repositoryFood.save(new Food(17L,"Red Volt", "Desserts",35));
            repositoryFood.save(new Food(18L,"A Strip of seven Macarons", "Desserts",65));
        }
    }
}