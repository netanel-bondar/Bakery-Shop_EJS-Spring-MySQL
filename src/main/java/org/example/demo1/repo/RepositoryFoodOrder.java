package org.example.demo1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * the database for the {@link FoodOrder}
 */
public interface RepositoryFoodOrder extends JpaRepository<FoodOrder, Long> {
}
