package com.example.sop_credit_assessment.services.impl;

import com.example.sop_credit_assessment.dtos.ClientDto;
import com.example.sop_credit_assessment.models.Client;
import com.example.sop_credit_assessment.repositories.ClientRepository;
import com.example.sop_credit_assessment.services.ClientService;
import com.example.sop_credit_assessment.util.ValidationUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    private final ModelMapper modelMapper;

    private final ValidationUtil validationUtil;

    public ClientServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void addClient(ClientDto clientDto) {
        if (!this.validationUtil.isValid(clientDto)) {

            this.validationUtil
                    .violations(clientDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal argument!");
        }
        Client client = modelMapper.map(clientDto, Client.class);
        client.setCreated(LocalDateTime.now());
        this.clientRepository.save(client);
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto) {
        if (!this.validationUtil.isValid(clientDto)) {

            this.validationUtil
                    .violations(clientDto)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal argument!");
        }
        Optional<Client> oldClient = clientRepository.findById(clientDto.getId());
        if (oldClient.isEmpty()) {
            throw new EntityNotFoundException("Клиента с таким ID нет: " + clientDto.getId());
        }
        Client client = modelMapper.map(clientDto, Client.class);
        client.setCreated(oldClient.get().getCreated());
        client.setModified(LocalDateTime.now());
        return modelMapper.map(this.clientRepository.save(client), ClientDto.class);
    }

    @Override
    public ClientDto findClientDtoById(UUID uuid) {
        return modelMapper.map(this.clientRepository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Клиента с таким ID нет!")), ClientDto.class);
    }

    @Override
    public List<ClientDto> findAllClients() {
        return this.clientRepository
                .findAll()
                .stream()
                .map(client -> modelMapper.map(client, ClientDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> findClientById(UUID uuid) {
        return this.clientRepository.findById(uuid);
    }
}
