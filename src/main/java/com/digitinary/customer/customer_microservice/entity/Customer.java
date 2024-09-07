package com.digitinary.customer.customer_microservice.entity;

import com.digitinary.customer.customer_microservice.enums.CustomerType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;



@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private String mobileNo;


    @Enumerated(EnumType.STRING)
    @Column
    private CustomerType type;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;

    @OneToOne(cascade = CascadeType.ALL)
    private Organization organization;

    private void setId(Long id) {
        this.id = id;
    }
}
