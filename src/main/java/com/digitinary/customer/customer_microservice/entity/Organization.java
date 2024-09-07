package com.digitinary.customer.customer_microservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String registrationNo;
    private String legalName;
    private String trademarkName;
    @OneToMany
    private List<Address> addresses;



    private void setId(Long id) {
        this.id = id;
    }
}
