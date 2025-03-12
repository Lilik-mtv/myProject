package main.java.com.itschool.dealership_management.mapper.impl;

import com.itschool.dealership_management.dto.ClientDto;
import com.itschool.dealership_management.mapper.ObjectMapper;
import com.itschool.dealership_management.persistence.entity.Address;
import com.itschool.dealership_management.persistence.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper implements ObjectMapper<ClientDto, Client> {

    private final  ObjectMapper<ClientDto.AddressDto, Address> addressMapper;

    public ClientMapper(ObjectMapper<ClientDto.AddressDto, Address> addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public ClientDto mapToDo(Client client) {
        return new ClientDto(
                client.getId(),
                client.getName(),
                addressMapper.mapToDo(client.getAddress())
        );
    }

    @Override
    public Client mapToEntity(ClientDto clientDto) {
        Client client = new Client();

        client.setName(clientDto.getName());
        client.setAddress(addressMapper.mapToEntity(clientDto.getAddress()));

        return client;
    }
}
