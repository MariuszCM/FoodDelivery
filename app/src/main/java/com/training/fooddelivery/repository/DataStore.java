package com.training.fooddelivery.repository;

import com.training.fooddelivery.domain.Customer;
import com.training.fooddelivery.domain.Food;
import com.training.fooddelivery.domain.Order;

import java.util.List;

public interface DataStore {
    List<Customer> getCustomers();

    List<Food> getFoods();

    List<Order> getOrders();

    Order createOrder(Order order);

}
