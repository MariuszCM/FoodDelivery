package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.domain.Food;
import com.epam.training.fooddelivery.repository.FoodRepository;
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
