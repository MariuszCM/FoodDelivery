package com.epam.training.fooddelivery.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
public class Cart {
    private BigDecimal price;
    private List<OrderItem> orderItems;

    public Cart() {
        this.price = new BigDecimal(0);
        this.orderItems = new ArrayList<>();
    }
}
