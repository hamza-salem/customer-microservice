package com.digitinary.customer.customer_microservice.model;


import com.digitinary.customer.customer_microservice.entity.Address;
import com.digitinary.customer.customer_microservice.entity.Organization;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrganizationModel {

    private String registrationNo;
    private String legalName;
    private String trademarkName;
    @OneToMany
    private List<AddressModel> addresses;


    public static Organization convertToEntity(OrganizationModel organizationModel) {
        Organization organization = new Organization();

        organization.setLegalName(organizationModel.getLegalName());
        organization.setTrademarkName(organizationModel.getTrademarkName());
        organization.setRegistrationNo(organizationModel.getRegistrationNo());
        organization.setAddresses(organizationModel.getAddresses().stream().map(AddressModel::convertToEntity).toList());

        return organization;
    }

    public void validateRequest() throws Exception {
        if(ObjectUtils.isEmpty(registrationNo)){
            throw new Exception("registration number cannot be empty");
        }

        if(ObjectUtils.isEmpty(legalName)){
            throw new Exception("legal name cannot be empty");
        }

        if(ObjectUtils.isEmpty(trademarkName)){
            throw new Exception("trademark name cannot be empty");
        }
    }
}
