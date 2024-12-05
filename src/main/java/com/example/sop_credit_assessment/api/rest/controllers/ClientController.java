package com.example.sop_credit_assessment.api.rest.controllers;

import com.example.sop_credit_assessment.api.rest.hateoas.assembler.ClientAssembler;
import com.example.sop_credit_assessment.api.rest.hateoas.model.ClientModel;
import com.example.sop_credit_assessment.dtos.ClientDto;
import com.example.sop_credit_assessment.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    private ClientAssembler clientAssembler;

    @Autowired
    public void setClientAssembler(ClientAssembler clientAssembler) {
        this.clientAssembler = clientAssembler;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    public void addClient(@RequestBody ClientDto clientDto) {
        clientService.addClient(clientDto);
    }

    @PostMapping("/update")
    public ClientModel updateClient(@RequestBody ClientDto clientDto) {
        return clientAssembler.toModel(clientService.updateClient(clientDto));
    }

    @GetMapping("/all")
    public CollectionModel<ClientModel> getAllClients() {
        return clientAssembler.toCollectionModel(clientService.findAllClients());
    }

    @GetMapping("/{id}")
    public ClientModel findClientById(@PathVariable UUID id) {
        return clientAssembler.toModel(clientService.findClientDtoById(id));
    }
}
