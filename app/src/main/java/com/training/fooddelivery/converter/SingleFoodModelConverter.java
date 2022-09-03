package com.training.fooddelivery.converter;

import com.training.fooddelivery.domain.Category;
import com.training.fooddelivery.domain.Food;
import com.training.fooddelivery.model.FoodModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SingleFoodModelConverter implements Converter<FoodModel, Food> {

    @Override
    public Food convert(FoodModel foodModel) {
        Food food = new Food();
        food.setId(foodModel.getId());
        food.setName(foodModel.getName());
        food.setPrice(new BigDecimal(foodModel.getPrice()));
        food.setCalorie(new BigDecimal(foodModel.getCalorie()));
        food.setDescription(foodModel.getDescription());
        food.setCategory(Category.valueOf(foodModel.getCategory()));
        return food;
    }
}
