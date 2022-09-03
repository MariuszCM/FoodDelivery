package com.training.fooddelivery.converter;

import com.training.fooddelivery.domain.Food;
import com.training.fooddelivery.model.FoodModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SingleFoodConverter implements Converter<Food, FoodModel> {

    @Override
    public FoodModel convert(Food food) {
        FoodModel foodModel = new FoodModel();
        foodModel.setName(food.getName());
        foodModel.setId(food.getId());
        foodModel.setCalorie(food.getCalorie().doubleValue());
        foodModel.setPrice(food.getPrice().doubleValue());
        foodModel.setCategory(food.getCategory().toString());
        foodModel.setDescription(food.getDescription());
        return foodModel;
    }
}
