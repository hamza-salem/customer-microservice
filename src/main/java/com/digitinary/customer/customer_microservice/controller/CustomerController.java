package com.digitinary.customer.customer_microservice.controller;


import com.digitinary.customer.customer_microservice.entity.Customer;
import com.digitinary.customer.customer_microservice.model.CustomerModel;
import com.digitinary.customer.customer_microservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@Validated @RequestBody CustomerModel customerModel) throws Exception {
        customerService.createCustomer(customerModel);
    }


    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) throws Exception {
        customerService.deleteCustomer(id);
    }


//    @PutMapping("/{id}")
//    public void updateCustomer(@PathVariable("id") Long id,CustomerModel customerModel) throws Exception {
//        customerService.updateCustomer(id,customerModel);
//    }



}
