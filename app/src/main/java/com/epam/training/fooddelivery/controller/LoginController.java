package com.epam.training.fooddelivery.controller;

import com.epam.training.fooddelivery.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private CustomerRepository customerRepository;

    public LoginController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public String login(){
        return "Hello";
    }

    @GetMapping
    @ResponseBody
    public String getId(HttpSession session){
        Object id = session.getAttribute("id");
        return id.toString();
    }
}
