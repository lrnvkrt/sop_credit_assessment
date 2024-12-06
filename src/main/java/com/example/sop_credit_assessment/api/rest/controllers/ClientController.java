package com.example.sop_credit_assessment.api.rest.controllers;

import com.example.sop_contracts.models.ClientModel;
import com.example.sop_contracts.requests.ClientRequest;
import com.example.sop_credit_assessment.api.rest.hateoas.assembler.ClientAssembler;
import com.example.sop_credit_assessment.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientController implements com.example.sop_contracts.controllers.ClientController {

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
    @Override
    public void addClient(@RequestBody ClientRequest clientDto) {
        clientService.addClient(clientDto);
    }

    @PostMapping("/update")
    @Override
    public ClientModel updateClient(@RequestBody ClientRequest clientDto) {
        return clientAssembler.toModel(clientService.updateClient(clientDto));
    }

    @GetMapping("/all")
    @Override
    public CollectionModel<ClientModel> getAllClients() {
        return clientAssembler.toCollectionModel(clientService.findAllClients());
    }

    @GetMapping("/{id}")
    @Override
    public ClientModel getClientById(@PathVariable UUID id) {
        return clientAssembler.toModel(clientService.findClientDtoById(id));
    }
}
