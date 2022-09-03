package com.training.fooddelivery.repository;

import com.training.fooddelivery.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByPasswordAndEmail(String password, String email);

    Optional<Customer> findCustomerByEmail(String email);

    Optional<Customer> findById(Long id);
}
