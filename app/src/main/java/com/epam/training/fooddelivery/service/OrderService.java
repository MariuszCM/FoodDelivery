package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.domain.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Customer customer);
    Order findOrderById(Long OrderId);
    List<Order> findAllOrdersByCustomerId(Long customerId);
}
