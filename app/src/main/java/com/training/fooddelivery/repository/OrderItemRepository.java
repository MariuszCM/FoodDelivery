package com.training.fooddelivery.repository;

import com.training.fooddelivery.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    Optional<List<OrderItem>> findAllByOrder_Id(Long id);
//    Optional<OrderItem> findByOrder_Id(Long id);
}
