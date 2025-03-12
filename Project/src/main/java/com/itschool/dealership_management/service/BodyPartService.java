package main.java.com.itschool.dealership_management.service;

import com.itschool.dealership_management.dto.BodyPartDto;
import com.itschool.dealership_management.dto.CarDto;
import com.itschool.dealership_management.mapper.ObjectMapper;
import com.itschool.dealership_management.persistence.entity.BodyPart;
import com.itschool.dealership_management.persistence.entity.Car;
import com.itschool.dealership_management.persistence.repository.BodyPartRepository;
import com.itschool.dealership_management.persistence.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodyPartService {

    private final BodyPartRepository bodyPartRepository;
    private final ObjectMapper<BodyPartDto, BodyPart> bodyPartMapper;


    public BodyPartService(BodyPartRepository bodyPartRepository, ObjectMapper<BodyPartDto, BodyPart> bodyPartMapper) {
        this.bodyPartRepository = bodyPartRepository;
        this.bodyPartMapper = bodyPartMapper;
    }

    public List<BodyPartDto> getAllBodyParts() {
        List<BodyPart> allBodyParts = bodyPartRepository.findAll();

        return allBodyParts.stream()
                .map(bodyPartMapper::mapToDo)
                .toList();
    }


    public BodyPartDto getBodyPartById(long id) {
        BodyPart referenceById = bodyPartRepository.getReferenceById(id);

        return bodyPartMapper.mapToDo(referenceById);
    }


    public void addBodyPart(BodyPartDto bodyPartDto){
        BodyPart bodyPart = bodyPartMapper.mapToEntity(bodyPartDto);
        bodyPartRepository.save(bodyPart);
    }


    public void deleteBodyPartById(long id) {
        bodyPartRepository.deleteById(id);
    }


    public void updateBodyPart(BodyPartDto bodyPartDto, BodyPartDto existingBodyPartDto) {

        if (bodyPartDto.getPartName() != null) {
            existingBodyPartDto.setPartName(bodyPartDto.getPartName());
        }

        if (bodyPartDto.getPartMake() != null) {
            existingBodyPartDto.setPartMake(bodyPartDto.getPartMake());
        }

        if (bodyPartDto.getPartModel() != null) {
            existingBodyPartDto.setPartModel(bodyPartDto.getPartModel());
        }


        if (bodyPartDto.getPartYear() != 0) {
            existingBodyPartDto.setPartYear(bodyPartDto.getPartYear());
        }

        if (bodyPartDto.getPartPrice() != 0) {
            existingBodyPartDto.setPartPrice(bodyPartDto.getPartPrice());
        }


    }



    public void replaceBodyPart (BodyPartDto bodyPartDto, BodyPartDto existingBodyPartDto) {

        existingBodyPartDto.setPartName(bodyPartDto.getPartName());
        existingBodyPartDto.setPartMake(bodyPartDto.getPartMake());
        existingBodyPartDto.setPartModel(bodyPartDto.getPartModel());
        existingBodyPartDto.setPartYear(bodyPartDto.getPartYear());
        existingBodyPartDto.setPartPrice(bodyPartDto.getPartPrice());

    }





}
