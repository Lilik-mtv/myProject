package main.java.com.itschool.dealership_management.mapper.impl;

import com.itschool.dealership_management.dto.BodyPartDto;
import com.itschool.dealership_management.mapper.ObjectMapper;
import com.itschool.dealership_management.persistence.entity.BodyPart;
import org.springframework.stereotype.Component;

@Component("bodyPartMapper")
public class BodyPartMapper implements ObjectMapper<BodyPartDto, BodyPart> {




    @Override
    public BodyPartDto mapToDo(BodyPart bodyPart) {
        return new BodyPartDto(

                bodyPart.getId(),
                bodyPart.getPartName(),
                bodyPart.getPartMake(),
                bodyPart.getPartModel(),
                bodyPart.getPartYear(),
                bodyPart.getPartYear()
        );
    }

    @Override
    public BodyPart mapToEntity(BodyPartDto bodyPartDto) {
        BodyPart bodyPart = new BodyPart();
        bodyPart.setPartName(bodyPartDto.getPartName());
        bodyPart.setPartMake(bodyPartDto.getPartMake());
        bodyPart.setPartModel(bodyPartDto.getPartModel());
        bodyPart.setPartYear(bodyPartDto.getPartYear());
        bodyPart.setPartPrice(bodyPartDto.getPartPrice());
        return bodyPart;
    }
}
