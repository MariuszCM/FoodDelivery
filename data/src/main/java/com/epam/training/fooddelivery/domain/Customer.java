package com.epam.training.fooddelivery.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal balance;
    @Transient
    private Cart cart;
    @Transient
    private List<Order> orders;

    public Customer() {
        this.cart = new Cart();
        this.orders = new ArrayList<>();
    }

}
