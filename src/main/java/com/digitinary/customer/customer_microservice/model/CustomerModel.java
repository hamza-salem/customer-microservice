package com.digitinary.customer.customer_microservice.model;

import com.digitinary.customer.customer_microservice.entity.Address;
import com.digitinary.customer.customer_microservice.entity.Customer;
import com.digitinary.customer.customer_microservice.entity.Organization;
import com.digitinary.customer.customer_microservice.enums.CustomerType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;




@Getter
@Setter
@ToString
@NoArgsConstructor
public class CustomerModel {

    @NotNull(message = "name cannot be empty")
    @Size(max=250, message = "name cannot exceed 250 character")
    private String name;

    @NotNull(message = "mobile number cannot be empty")
    private String mobileNo;

    @NotNull(message = "type cannot be empty")
    private String type;

    private List<AddressModel> addresses;

    private OrganizationModel organization;


    public static Customer getInstance(CustomerModel customerModel) {

        Customer customer = new Customer();
        customer.setName(customerModel.getName());
        customer.setType(CustomerType.valueOf(customerModel.getType()));
        customer.setMobileNo(customerModel.getMobileNo());
        customer.setAddresses(customerModel.getAddresses().stream().map(AddressModel::convertToEntity).toList());
        if (customerModel.getOrganization() != null){
            customer.setOrganization(OrganizationModel.convertToEntity(customerModel.getOrganization()));
        }

        return customer;

    }

    public void validateRequest() throws Exception {
        CustomerType customerType = CustomerType.valueOf(getType());

        if(customerType.equals(CustomerType.Organization) && organization == null){
            throw new Exception("organization data cannot be empty for customer type of organization");
        }else if(customerType.equals(CustomerType.Organization)){
            organization.validateRequest();
        }
    }
}
