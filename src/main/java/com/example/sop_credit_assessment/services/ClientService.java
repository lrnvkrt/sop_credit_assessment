package com.example.sop_credit_assessment.services;

import com.example.sop_contracts.requests.ClientRequest;
import com.example.sop_credit_assessment.models.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {

    void addClient(ClientRequest clientDto);

    ClientRequest updateClient(ClientRequest clientDto);

    ClientRequest findClientDtoById(UUID uuid);

    ClientRequest findClientDtoByCif(String cif);

    Optional<Client> findClientById(UUID uuid);

    List<ClientRequest> findAllClients();
}
