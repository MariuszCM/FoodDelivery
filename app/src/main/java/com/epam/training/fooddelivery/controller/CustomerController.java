package com.epam.training.fooddelivery.controller;

import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.domain.User;
import com.epam.training.fooddelivery.model.OrderModel;
import com.epam.training.fooddelivery.repository.CustomerRepository;
import com.epam.training.fooddelivery.service.CustomerService;
import com.epam.training.fooddelivery.view.View;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class CustomerController {

    private CustomerService customerService;
    private View view;

    public CustomerController(CustomerService customerService, View view) {
        this.customerService = customerService;
        this.view = view;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Customer> login(@RequestParam String email, @RequestParam String password){
        User user = new User(email, password);
        Customer authenticatedCustomer = customerService.authenticate(user);
        view.printWelcomeMessage(authenticatedCustomer);
        return new ResponseEntity<>(authenticatedCustomer, HttpStatus.OK);
    }
}
