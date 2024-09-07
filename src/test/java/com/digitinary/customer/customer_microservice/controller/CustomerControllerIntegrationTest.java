package com.digitinary.customer.customer_microservice.controller;

import com.digitinary.customer.customer_microservice.model.AddressModel;
import com.digitinary.customer.customer_microservice.model.CustomerModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Positive test case for creating a customer
    @Test
    public void shouldCreateCustomer() throws Exception {
        CustomerModel customerModel = new CustomerModel();
        // set valid customerModel data
        customerModel.setName("John Doe");
        customerModel.setType("Individual");
        customerModel.setMobileNo("1234567890");
        // Add other fields as per your model

        AddressModel addressModel = new AddressModel();

        addressModel.setCity("Amman");
        addressModel.setLineOne("Amman");
        addressModel.setLineTwo("Amman");
        addressModel.setPostalCode("Amman");
        addressModel.setCountry("JO");
        customerModel.setAddresses(List.of(addressModel));

        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerModel)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(print());
    }

    @Test
    public void shouldReturnBadRequestForInvalidCustomer() throws Exception {
        CustomerModel customerModel = new CustomerModel();

        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerModel)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(print());
    }


    @Test
    public void shouldDeleteCustomer() throws Exception {
        shouldCreateCustomer();

        Long customerId = 1L; //assuming in memory database

        mockMvc.perform(delete("/customers/{id}", customerId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }


}