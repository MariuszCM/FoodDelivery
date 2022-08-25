package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.domain.Order;
import com.epam.training.fooddelivery.domain.OrderItem;
import com.epam.training.fooddelivery.exception.LowBalanceException;
import com.epam.training.fooddelivery.repository.CustomerRepository;
import com.epam.training.fooddelivery.repository.OrderItemRepository;
import com.epam.training.fooddelivery.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
@AllArgsConstructor
public class DefaultOrderService implements OrderService {
    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;
    private CustomerRepository customerRepository;

    @Transactional
    @Override
    public Order createOrder(Customer customer) {
        checkExceptions(customer);

        LocalDateTime currentDate = LocalDateTime.now();
        Order order = new Order(customer, customer.getCart().getPrice(),
                currentDate, customer.getCart().getOrderItems());
        customer.getOrders().add(order);

        addOrderItemsToRepository(customer, order);
        orderRepository.save(order);

        updateCustomerBalance(customer, order);
        return order;
    }

    private void updateCustomerBalance(Customer customer, Order order) {
        BigDecimal balanceAfterOrder = customer.getBalance().subtract(order.getPrice());
        customer.setBalance(balanceAfterOrder);
        customerRepository.save(customer);
    }

    private void addOrderItemsToRepository(Customer customer, Order order) {
        customer.getCart().getOrderItems().forEach(orderItem -> orderItem.setOrder(order));
        orderItemRepository.saveAll(customer.getCart().getOrderItems());
    }

    private void checkExceptions(Customer customer) {
        if (customer.getCart().getPrice().equals(BigDecimal.valueOf(0))) {
            throw new IllegalStateException("Cart is empty!");
        }
        if (customer.getBalance().compareTo(customer.getCart().getPrice()) < 0) {
            throw new LowBalanceException("You don't have enough money, your balance is only "
                    + customer.getBalance() + " EUR. We do not empty your cart, " +
                    "please remove some of the items.");
        }
    }
    //TODO Rebuild
    @Override
    public Order findOrderById(Long id){
        Optional<Order> order = orderRepository.findById(id);
        List<OrderItem> orderItems = orderItemRepository.findAllByOrder_Id(id).orElse(null);
        order.ifPresent(orderLambda -> orderLambda.setOrderItems(orderItems));
        return order.orElse(null);
    }

    @Override
    public List<Order> findAllOrdersByCustomerId(Long customerId) {
        List<Order> orderList = orderRepository.findAllOrdersByCustomerId(customerId).orElse(new ArrayList<>());
        for (Order order : orderList) {
            Long orderId = order.getId();
            List<OrderItem> orderItems = orderItemRepository.findAllByOrder_Id(orderId).orElse(null);
            order.setOrderItems(orderItems);
        }
        return orderList;
    }
}
