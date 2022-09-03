package com.training.fooddelivery.service;

import com.training.fooddelivery.domain.Food;

import java.util.List;

public interface FoodService {
    List<Food> listAllFood();
    Food findFoodById(Long foodId);
}
