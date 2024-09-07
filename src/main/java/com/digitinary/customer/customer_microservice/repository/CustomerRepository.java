package com.digitinary.customer.customer_microservice.repository;

import com.digitinary.customer.customer_microservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
