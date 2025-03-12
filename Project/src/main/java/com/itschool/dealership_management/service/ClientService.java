package main.java.com.itschool.dealership_management.service;


import com.itschool.dealership_management.dto.ClientDto;
import com.itschool.dealership_management.mapper.ObjectMapper;

import com.itschool.dealership_management.persistence.entity.Client;
import com.itschool.dealership_management.persistence.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ObjectMapper<ClientDto, Client> clientMapper;

    public ClientService(ClientRepository clientRepository,
                         ObjectMapper<ClientDto, Client> clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public ClientDto createClient(ClientDto client ) {
       Client entity = clientMapper.mapToEntity(client);

       return clientMapper.mapToDo(clientRepository.save(entity));

    }

    public List<ClientDto>getClients(){
       return clientRepository.findAll().stream()
                .map(clientMapper::mapToDo)
                .toList();
    }

    public void deleteClientById(long id) {
        clientRepository.deleteById(id);
    }

    public ClientDto getClientById(long id) {
        Client referenceById = clientRepository.getReferenceById(id);

        return clientMapper.mapToDo(referenceById);
    }

    public void updateClient (ClientDto clientDto, ClientDto existingClientDto) {
        if (clientDto.getName() != null) {
            existingClientDto.setName(clientDto.getName());
        }


    }





    public void replaceClient (ClientDto clientDto, ClientDto existingClientDto) {
        existingClientDto.setName(clientDto.getName());


    }



}


