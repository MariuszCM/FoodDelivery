package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerService {
    Customer authenticate(User user);
    Customer findByEmailAndPassword(String email, String password);
}
