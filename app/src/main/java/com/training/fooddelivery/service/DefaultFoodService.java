package com.training.fooddelivery.service;

import com.training.fooddelivery.domain.Food;
import com.training.fooddelivery.repository.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class DefaultFoodService implements FoodService {
    private FoodRepository foodRepository;

    @Transactional
    @Override
    public List<Food> listAllFood() {
        return foodRepository.findAll();
    }
}
