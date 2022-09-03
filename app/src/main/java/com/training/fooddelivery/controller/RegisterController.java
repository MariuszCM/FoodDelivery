package com.training.fooddelivery.controller;

import com.training.fooddelivery.domain.Customer;
import com.training.fooddelivery.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private CustomerService customerService;

    public RegisterController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String registerTemplate() {
        return "register";
    }

    @PostMapping
    public String createAccount(HttpServletRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getParameter("name"));
        customer.setBalance(BigDecimal.valueOf(Long.parseLong(request.getParameter("balance"))));
        customer.setEmail(request.getParameter("email"));
        customer.setPassword(request.getParameter("password"));
        customerService.createCustomer(customer);
        return "successfulRegister";
    }


}
