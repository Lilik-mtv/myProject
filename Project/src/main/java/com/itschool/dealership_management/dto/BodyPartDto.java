package main.java.com.itschool.dealership_management.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BodyPartDto {


    private Long id;

    private String partName;
    private String partMake;
    private String partModel;
    private int partYear;
    private double partPrice;
}
