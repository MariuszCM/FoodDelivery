package com.epam.training.fooddelivery.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@ToString(exclude = "customer")
@NoArgsConstructor
@Table(name = "_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private BigDecimal price;
    private LocalDateTime timestampCreated;
    @Transient
    private List<OrderItem> orderItems;

    public Order(Customer customer, BigDecimal price, LocalDateTime timestampCreated, List<OrderItem> orderItems) {
        this.customer = customer;
        this.price = price;
        this.timestampCreated = timestampCreated;
        this.orderItems = orderItems;
    }
}
