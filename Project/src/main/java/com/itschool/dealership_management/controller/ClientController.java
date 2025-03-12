package main.java.com.itschool.dealership_management.controller;


import com.itschool.dealership_management.dto.CarDto;
import com.itschool.dealership_management.dto.ClientDto;
import com.itschool.dealership_management.dto.ClientDto;
import com.itschool.dealership_management.persistence.entity.Client;
import com.itschool.dealership_management.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;

    }

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto client) {

        return new ResponseEntity<>(clientService.createClient(client), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients() {
        return ResponseEntity.ok(clientService.getClients());

    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable long id) {
        clientService.deleteClientById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable long id, @RequestBody ClientDto clientDto) {

        ClientDto existingClientDto = clientService.getClientById(id);

        if (existingClientDto == null) {
            return ResponseEntity.notFound().build();
        }

        clientService.updateClient(clientDto, existingClientDto);

        return ResponseEntity.ok(existingClientDto);
    }



    @PutMapping("/{id}")

    public ResponseEntity<ClientDto> replaceClient(@PathVariable long id, @RequestBody ClientDto clientDto) {

        ClientDto existingClientDto = clientService.getClientById(id);

        if (existingClientDto == null) {

            return ResponseEntity.notFound().build();

        }
        clientService.replaceClient(clientDto, existingClientDto);

        return ResponseEntity.ok(existingClientDto);


    }


}