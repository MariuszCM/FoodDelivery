package com.training.fooddelivery.service;

import com.training.fooddelivery.domain.Customer;
import com.training.fooddelivery.domain.User;
import com.training.fooddelivery.exception.AuthenticationException;
import com.training.fooddelivery.repository.CustomerRepository;
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

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
