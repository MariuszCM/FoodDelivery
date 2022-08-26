package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.domain.User;
import com.epam.training.fooddelivery.exception.AuthenticationException;
import com.epam.training.fooddelivery.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@AllArgsConstructor
@Service
public class DefaultCustomerService implements CustomerService {
    private CustomerRepository customerRepository;

    @Transactional
    @Override
    public Customer authenticate(User user) {
        return customerRepository.findByPasswordAndEmail(user.getPassword(), user.getEmail())
                .orElseThrow(() -> {
                    throw new AuthenticationException("User not found!\n");
                });
    }

    @Override
    public Customer findByEmailAndPassword(String email, String password) {
        return customerRepository.findByPasswordAndEmail(password, email).orElseThrow(() -> new AuthenticationException("Wrong credentials"));
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email).orElseThrow(() -> new AuthenticationException("Wrong credentials"));
    }
}
