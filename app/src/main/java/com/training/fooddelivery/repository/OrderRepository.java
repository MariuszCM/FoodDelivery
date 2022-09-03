package com.training.fooddelivery.repository;

import com.training.fooddelivery.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long orderId);

    Optional<List<Order>> findAllOrdersByCustomerId(Long customerId);
}
