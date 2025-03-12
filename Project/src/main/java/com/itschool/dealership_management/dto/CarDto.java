package main.java.com.itschool.dealership_management.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CarDto {
    private final long id;

    private String make;
    private String model;
    private int year;
    private double price;

}
