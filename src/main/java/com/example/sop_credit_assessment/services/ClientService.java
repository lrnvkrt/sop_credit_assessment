package com.example.sop_credit_assessment.services;

import com.example.sop_credit_assessment.dtos.ClientDto;
import com.example.sop_credit_assessment.models.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientService {

    void addClient(ClientDto clientDto);

    ClientDto updateClient(ClientDto clientDto);

    ClientDto findClientDtoById(UUID uuid);

    Optional<Client> findClientById(UUID uuid);

    List<ClientDto> findAllClients();
}
