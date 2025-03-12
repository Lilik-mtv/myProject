package main.java.com.itschool.dealership_management.service;

import com.itschool.dealership_management.dto.CarDto;
import com.itschool.dealership_management.mapper.ObjectMapper;
import com.itschool.dealership_management.persistence.entity.Car;
import com.itschool.dealership_management.persistence.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final ObjectMapper<CarDto, Car> carMapper;


    public CarService(CarRepository carRepository, ObjectMapper<CarDto, Car> carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

      public List<CarDto> getAllCars() {
        List<Car> allCars = carRepository.findAll();

        return allCars.stream()
                .map(carMapper::mapToDo)
               .toList();
    }

    public CarDto getCarById(long id) {
        Car referenceById = carRepository.getReferenceById(id);

        return carMapper.mapToDo(referenceById);
    }

    public void addCar(CarDto carDto){
        Car car = carMapper.mapToEntity(carDto);
        carRepository.save(car);
    }

    public void deleteCarById(long id) {
        carRepository.deleteById(id);
    }



    public void updateCar(CarDto carDto, CarDto existingCarDto) {
        if (carDto.getMake() != null) {
            existingCarDto.setMake(carDto.getMake());
        }

        if (carDto.getModel() != null) {
            existingCarDto.setModel(carDto.getModel());
        }

        if (carDto.getYear() != 0) {
            existingCarDto.setYear(carDto.getYear());
        }

        if (carDto.getPrice() != 0) {
            existingCarDto.setPrice(carDto.getPrice());
        }

    }




    public void replaceCar (CarDto carDto, CarDto existingCarDto) {
        existingCarDto.setMake(carDto.getMake());
        existingCarDto.setModel(carDto.getModel());
        existingCarDto.setYear(carDto.getYear());
        existingCarDto.setPrice(carDto.getPrice());

    }

}
