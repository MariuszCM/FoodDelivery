package com.training.fooddelivery.controller;

import com.training.fooddelivery.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private CustomerRepository customerRepository;

    public LoginController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    //@ResponseBody
    public String login(Model model) {
        model.addAttribute("userName", getAuthenticatedCustomersName());
        return "startPage";
    }

    @GetMapping
    @ResponseBody
    public String getId(HttpSession session) {
        Object id = session.getAttribute("id");
        return id.toString();
    }

    private String getAuthenticatedCustomersName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String customerEmail = userDetails.getUsername();
        String name = customerRepository.findCustomerByEmail(customerEmail).get().getName();
        return name;
    }
}
