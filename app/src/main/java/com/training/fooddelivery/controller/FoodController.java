package com.training.fooddelivery.controller;

import com.training.fooddelivery.api.FoodserviceApi;
import com.training.fooddelivery.converter.FoodListConverter;
import com.training.fooddelivery.domain.Food;
import com.training.fooddelivery.model.FoodModel;
import com.training.fooddelivery.service.FoodService;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping(value = "/main/description/{foodId}")
    public String description(@PathVariable Long foodId, Model model) {
        Food food = foodService.findFoodById(foodId);
        model.addAttribute("foodId", food.getId());
        model.addAttribute("foodName", food.getName());
        model.addAttribute("foodDescription", food.getDescription());
        model.addAttribute("foodCalorie", food.getCalorie());
        model.addAttribute("foodPrice", food.getPrice());
        return "description";
    }
}
