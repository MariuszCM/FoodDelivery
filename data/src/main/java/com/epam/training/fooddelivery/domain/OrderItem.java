package com.epam.training.fooddelivery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@ToString(exclude = "order")
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int pieces;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderItem(int pieces, BigDecimal price, Food food) {
        this.pieces = pieces;
        this.price = price;
        this.food = food;
    }

}
