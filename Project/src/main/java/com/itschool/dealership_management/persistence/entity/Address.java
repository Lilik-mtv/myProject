package main.java.com.itschool.dealership_management.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String city;
    private String street;
    private String number;

    @OneToOne(mappedBy = "address")
    private Client client;


}
