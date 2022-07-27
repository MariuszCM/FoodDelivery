package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.domain.User;
import com.epam.training.fooddelivery.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


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
}
