package com.epam.training.fooddelivery.controller;

import com.epam.training.fooddelivery.api.OrderserviceApi;
import com.epam.training.fooddelivery.converter.CartModelConverter;
import com.epam.training.fooddelivery.converter.OrderListConverter;
import com.epam.training.fooddelivery.converter.SingleOrderModelConverter;
import com.epam.training.fooddelivery.domain.Cart;
import com.epam.training.fooddelivery.domain.Order;
import com.epam.training.fooddelivery.exception.LowBalanceException;
import com.epam.training.fooddelivery.model.CartModel;
import com.epam.training.fooddelivery.model.OrderModel;
import com.epam.training.fooddelivery.service.CustomerService;
import com.epam.training.fooddelivery.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class OrderController implements OrderserviceApi {

    private OrderService orderService;
    private CustomerService customerService;
    private OrderListConverter orderListConverter;
    private SingleOrderModelConverter singleOrderModelConverter;
    private CartModelConverter cartModelConverter;

    public OrderController(OrderService orderService, CustomerService customerService, OrderListConverter orderListConverter, SingleOrderModelConverter singleOrderModelConverter, CartModelConverter cartModelConverter) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.orderListConverter = orderListConverter;
        this.singleOrderModelConverter = singleOrderModelConverter;
        this.cartModelConverter = cartModelConverter;
    }

    @Override
    public ResponseEntity<OrderModel> createOrder(@RequestBody CartModel cartModel) {
        return null;
    }

    @Override
    public ResponseEntity<OrderModel> getOrderById(Long orderId) {
        Order orderById = orderService.findOrderById(orderId);
        if (orderById == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            OrderModel orderModel = singleOrderModelConverter.convert(orderById);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<OrderModel>> listAllOrders() {
        List<Order> allOrdersByCustomerId = orderService.findAllOrdersByCustomerId(1L);
        List<OrderModel> orderModels = orderListConverter.convert(allOrdersByCustomerId);
        return new ResponseEntity<>(orderModels, HttpStatus.OK);
    }
}
