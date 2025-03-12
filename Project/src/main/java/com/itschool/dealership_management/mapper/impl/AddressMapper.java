package main.java.com.itschool.dealership_management.mapper.impl;

import com.itschool.dealership_management.dto.ClientDto;
import com.itschool.dealership_management.mapper.ObjectMapper;
import com.itschool.dealership_management.persistence.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements ObjectMapper<ClientDto.AddressDto,Address>  {


    @Override
    public ClientDto.AddressDto mapToDo(Address address) {
        return new ClientDto.AddressDto (
                address.getCity(),
                address.getStreet(),
                address.getNumber()
        );
    }

    @Override
    public Address mapToEntity(ClientDto.AddressDto addressDto) {
        Address address = new Address();

        address.setCity(addressDto.getCity());
        address.setStreet(address.getStreet());
        address.setNumber(addressDto.getNumber());
return address;
    }
}
