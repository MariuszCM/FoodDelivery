package com.epam.training.fooddelivery.repository;

import com.epam.training.fooddelivery.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findByName(String foodName);
}
