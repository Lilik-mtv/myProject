package main.java.com.itschool.dealership_management.controller;

import com.itschool.dealership_management.dto.BodyPartDto;
import com.itschool.dealership_management.dto.CarDto;
import com.itschool.dealership_management.persistence.entity.BodyPart;
import com.itschool.dealership_management.service.BodyPartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/body_parts")
public class BodyPartController {

    private final BodyPartService bodyPartService ;

    public BodyPartController(BodyPartService bodyPartService) {
        this.bodyPartService = bodyPartService;
    }

    @GetMapping
    public List<BodyPartDto> getAllBodyParts() {
        return bodyPartService.getAllBodyParts();

    }

    @GetMapping("/{id}")
    public ResponseEntity<BodyPartDto> getBodyPartById(@PathVariable long id) {

        BodyPartDto bodyPartDtoById = bodyPartService.getBodyPartById(id);

        if (bodyPartDtoById == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bodyPartDtoById);
    }


    @PostMapping
    public ResponseEntity<String> addBodyPart (@RequestBody BodyPartDto bodyPartDto) {
        bodyPartService.addBodyPart(bodyPartDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("BodyPart added successfully");
    }


    @DeleteMapping("/{id}")
    public void deleteBodyPart(@PathVariable long id) {
        bodyPartService.deleteBodyPartById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BodyPartDto> updateBodyPart (@PathVariable long id, @RequestBody BodyPartDto bodyPartDto) {

        BodyPartDto existingBodyPartDto = bodyPartService.getBodyPartById(id);

        if (existingBodyPartDto == null) {
            return ResponseEntity.notFound().build();
        }

        bodyPartService.updateBodyPart(bodyPartDto, existingBodyPartDto);

        return ResponseEntity.ok(existingBodyPartDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodyPartDto> replaceBodyPart(@PathVariable long id, @RequestBody BodyPartDto bodyPartDto) {

        BodyPartDto existingBodyPartDto = bodyPartService.getBodyPartById(id);

        if (existingBodyPartDto == null) {

            return ResponseEntity.notFound().build();

        }
        bodyPartService.replaceBodyPart(bodyPartDto, existingBodyPartDto);

        return ResponseEntity.ok(existingBodyPartDto);

    }



}
