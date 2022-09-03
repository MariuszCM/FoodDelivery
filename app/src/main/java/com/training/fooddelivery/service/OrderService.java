package com.training.fooddelivery.service;

import com.training.fooddelivery.domain.Cart;
import com.training.fooddelivery.domain.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Long customerId, Cart cart);

    Order findOrderById(Long OrderId);

    List<Order> findAllOrdersByCustomerId(Long customerId);
}
