package org.example.demo1.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * the database which holds the queries the {@link Food} entity.
 */
public interface RepositoryFood extends JpaRepository<Food, Long> {

    @Query("SELECT f FROM Food f WHERE f.category = 'Pastries'")
    List<Food> findPastries();

    @Query("SELECT f FROM Food f WHERE f.category = 'Breakfast'")
    List<Food> findBreakfast();

    @Query("SELECT f FROM Food f WHERE f.category = 'Cakes'")
    List<Food> findCakes();

    @Query("SELECT f FROM Food f WHERE f.category = 'Desserts'")
    List<Food> findDesserts();

    @Query("SELECT f FROM Food f WHERE f.category = 'HotDrinks'")
    List<Food> findHotDrinks();

    @Query("SELECT f FROM Food f WHERE f.category = 'ColdDrinks'")
    List<Food> findColdDrinks();

    @Query("SELECT f FROM Food f WHERE f.category = 'SoftDrinks'")
    List<Food> findSoftDrinks();

    @Query("SELECT f FROM Food f WHERE f.category = 'FreshJuices'")
    List<Food> findFreshJuices();
}
