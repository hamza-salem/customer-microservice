package com.digitinary.customer.customer_microservice.model;


import com.digitinary.customer.customer_microservice.entity.Address;
import com.digitinary.customer.customer_microservice.entity.Customer;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddressModel {

    private String lineOne;
    private String lineTwo;
    private String postalCode;
    private String city;
    private String country;




    public static Address convertToEntity(AddressModel addressModel) {
        Address address = new Address();
        address.setCity(addressModel.getCity());
        address.setCountry(addressModel.getCountry());
        address.setLineOne(addressModel.getLineOne());
        address.setLineTwo(addressModel.getLineTwo());
        address.setPostalCode(addressModel.getPostalCode());
        return address;
    }
}
