package com.training.fooddelivery.controller;

import com.training.fooddelivery.domain.Customer;
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
    private CustomerRepository customerRepository;

    public LoginController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public String login(Model model) {
        Customer customer = getAuthenticatedCustomer();
        model.addAttribute("userName", customer.getName());
        model.addAttribute("userBalance", customer.getBalance());
        return "startPage";
    }

    @GetMapping
    @ResponseBody
    public String getId(HttpSession session) {
        Object id = session.getAttribute("id");
        return id.toString();
    }

    private Customer getAuthenticatedCustomer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String customerEmail = userDetails.getUsername();
        return customerRepository.findCustomerByEmail(customerEmail).get();
    }
}
