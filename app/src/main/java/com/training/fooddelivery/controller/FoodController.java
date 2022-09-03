package com.training.fooddelivery.controller;

import com.training.fooddelivery.api.FoodserviceApi;
import com.training.fooddelivery.converter.FoodListConverter;
import com.training.fooddelivery.domain.Food;
import com.training.fooddelivery.model.FoodModel;
import com.training.fooddelivery.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FoodController implements FoodserviceApi {

    private FoodService foodService;
    private FoodListConverter foodListConverter;

    public FoodController(FoodService foodService, FoodListConverter foodListConverter) {
        this.foodService = foodService;
        this.foodListConverter = foodListConverter;
    }

    @Override
    public ResponseEntity<List<FoodModel>> listAllFoods() {
        List<Food> foodList = foodService.listAllFood();
        List<FoodModel> foodModelList = foodListConverter.convert(foodList);

        return new ResponseEntity<>(foodModelList, HttpStatus.OK);
    }
}
