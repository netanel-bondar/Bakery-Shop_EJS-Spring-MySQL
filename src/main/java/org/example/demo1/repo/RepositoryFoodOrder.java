package org.example.demo1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryFoodOrder extends JpaRepository<FoodOrder, Long> {
}
