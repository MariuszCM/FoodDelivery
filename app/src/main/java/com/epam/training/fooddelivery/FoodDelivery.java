package com.epam.training.fooddelivery;

import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.domain.Food;
import com.epam.training.fooddelivery.domain.Order;
import com.epam.training.fooddelivery.service.*;
import com.epam.training.fooddelivery.view.View;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class FoodDelivery implements CommandLineRunner {
    private View view;
    private CustomerService customerService;
    private FoodService foodService;
    private CartService cartService;
    private OrderService orderService;


    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer();
        boolean isAuthenticated = false;
        try {
            customer = customerService.authenticate(view.readCredentials());
            isAuthenticated = true;
        } catch (AuthenticationException e) {
            view.printErrorMessage(e.getMessage());
        }
        if (isAuthenticated) {
            view.printWelcomeMessage(customer);
            boolean decision;
            Order order = null;
            do {
                view.printAllFoods(foodService.listAllFood());
                Food food = view.selectFood(foodService.listAllFood());
                int foodPieces = view.readPieces();
                cartService.updateCart(customer, food, foodPieces);
                view.printAddedToCart(food, foodPieces);
                view.printCart(customer.getCart());
                decision = view.promptOrder();
                if (decision) {
                    try {
                        order = orderService.createOrder(customer);
                    } catch (LowBalanceException e) {
                        decision = false;
                    }
                }
            } while (!decision);
            view.printConfirmOrder(order);
        }

    }

}
