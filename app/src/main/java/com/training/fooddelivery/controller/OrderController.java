package com.training.fooddelivery.controller;

import com.training.fooddelivery.api.OrderserviceApi;
import com.training.fooddelivery.converter.CartModelConverter;
import com.training.fooddelivery.converter.OrderListConverter;
import com.training.fooddelivery.converter.SingleOrderModelConverter;
import com.training.fooddelivery.domain.Cart;
import com.training.fooddelivery.domain.Order;
import com.training.fooddelivery.exception.LowBalanceException;
import com.training.fooddelivery.model.CartModel;
import com.training.fooddelivery.model.OrderModel;
import com.training.fooddelivery.service.CustomerService;
import com.training.fooddelivery.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        if (cartModel.getOrderItemModels().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Cart cart = cartModelConverter.convert(cartModel);
        Long authenticatedCustomersId = getAuthenticatedCustomersId();
        try {
            Order order = orderService.createOrder(authenticatedCustomersId, cart);
            OrderModel orderModel = singleOrderModelConverter.convert(order);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        } catch (LowBalanceException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<OrderModel> getOrderById(Long id) {
        Long authenticatedCustomersId = getAuthenticatedCustomersId();
        Order orderById = orderService.findOrderById(id);
        if (orderById == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (!orderById.getCustomer().getId().equals(authenticatedCustomersId)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } else {
            OrderModel orderModel = singleOrderModelConverter.convert(orderById);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<List<OrderModel>> listAllOrders() {
        Long authenticatedCustomersId = getAuthenticatedCustomersId();
        List<Order> allOrdersByCustomerId = orderService.findAllOrdersByCustomerId(authenticatedCustomersId);
        List<OrderModel> orderModels = orderListConverter.convert(allOrdersByCustomerId);
        return new ResponseEntity<>(orderModels, HttpStatus.OK);
    }

    private Long getAuthenticatedCustomersId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String customerEmail = userDetails.getUsername();
        Long id = customerService.findCustomerByEmail(customerEmail).getId();
        return id;
    }
}
