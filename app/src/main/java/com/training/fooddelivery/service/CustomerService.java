package com.training.fooddelivery.service;

import com.training.fooddelivery.domain.Customer;
import com.training.fooddelivery.domain.User;

public interface CustomerService {
    Customer authenticate(User user);

    Customer findByEmailAndPassword(String email, String password);

    Customer findCustomerByEmail(String email);

    void createCustomer(Customer customer);
}
