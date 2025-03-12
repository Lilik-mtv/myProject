package main.java.com.itschool.dealership_management.controller;


import com.itschool.dealership_management.dto.CarDto;
import com.itschool.dealership_management.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarDto> getAllCars() {
        return carService.getAllCars();

    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable long id) {

        CarDto carDtoById = carService.getCarById(id);

        if (carDtoById == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carDtoById);
    }

    @PostMapping
    public ResponseEntity<String> addCar(@RequestBody CarDto carDto) {
        carService.addCar(carDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Car added successfully");
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id) {
        carService.deleteCarById(id);
    }



    @PatchMapping("/{id}")
    public ResponseEntity<CarDto> updateCar(@PathVariable long id, @RequestBody CarDto carDto) {

        CarDto existingCarDto = carService.getCarById(id);

        if (existingCarDto == null) {
            return ResponseEntity.notFound().build();
        }

        carService.updateCar(carDto, existingCarDto);

        return ResponseEntity.ok(existingCarDto);
    }



    @PutMapping("/{id}")
    public ResponseEntity<CarDto> replaceCar(@PathVariable long id, @RequestBody CarDto carDto) {

        CarDto existingCarDto = carService.getCarById(id);

        if (existingCarDto == null) {

            return ResponseEntity.notFound().build();

        }
        carService.replaceCar(carDto, existingCarDto);

        return ResponseEntity.ok(existingCarDto);

    }


}
