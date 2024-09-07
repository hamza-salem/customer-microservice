package com.digitinary.customer.customer_microservice.service;


import com.digitinary.customer.customer_microservice.entity.Customer;
import com.digitinary.customer.customer_microservice.enums.CustomerType;
import com.digitinary.customer.customer_microservice.model.CustomerModel;
import com.digitinary.customer.customer_microservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {


    private final CustomerRepository customerRepository;


    public void createCustomer(CustomerModel customerModel) throws Exception {
        customerModel.validateRequest();
        Customer customer = CustomerModel.getInstance(customerModel);
        customerRepository.save(customer);
    }


    public void deleteCustomer(Long id) throws Exception {
        Customer customer = customerRepository.findById(id).orElseThrow(()->new Exception("Customer not found"));
        customerRepository.delete(customer);
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).get();
    }
}
