package com.training.fooddelivery.converter;

import com.training.fooddelivery.domain.Food;
import com.training.fooddelivery.model.FoodModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoodListConverter implements Converter<List<Food>, List<FoodModel>> {

    @Override
    public List<FoodModel> convert(List<Food> foodList) {
        List<FoodModel> foodModels = new ArrayList<>();
        for (Food food : foodList) {
            FoodModel foodModel = new FoodModel();
            foodModel.setName(food.getName());
            foodModel.setId(food.getId());
            foodModel.setCalorie(food.getCalorie().doubleValue());
            foodModel.setPrice(food.getPrice().doubleValue());
            foodModel.setCategory(food.getCategory().toString());
            foodModel.setDescription(food.getDescription());
            foodModels.add(foodModel);
        }
        return foodModels;
    }


}
