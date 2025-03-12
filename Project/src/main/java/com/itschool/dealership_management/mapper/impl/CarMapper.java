package main.java.com.itschool.dealership_management.mapper.impl;

import com.itschool.dealership_management.dto.CarDto;
import com.itschool.dealership_management.mapper.ObjectMapper;
import com.itschool.dealership_management.persistence.entity.Car;
import org.springframework.stereotype.Component;

@Component("carMapper")
public class CarMapper implements ObjectMapper<CarDto, Car> {


    @Override
    public CarDto mapToDo(Car car) {
        return new CarDto(
                car.getId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getPrice()
        );
    }

    @Override
    public Car mapToEntity(CarDto carDto) {
        Car car = new Car();
        car.setMake(carDto.getMake());
        car.setModel(carDto.getModel());
        car.setYear(carDto.getYear());
        car.setPrice(carDto.getPrice());
        return car;
    }
}
