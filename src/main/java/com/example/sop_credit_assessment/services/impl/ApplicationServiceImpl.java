package com.example.sop_credit_assessment.services.impl;

import com.example.sop_contracts.enumerations.ApplicationStatus;
import com.example.sop_contracts.requests.ApplicationCreationRequest;
import com.example.sop_credit_assessment.dtos.ApplicationDto;
import com.example.sop_credit_assessment.models.Application;
import com.example.sop_credit_assessment.models.Client;
import com.example.sop_credit_assessment.records.messages.CreditCheckRequestMessage;
import com.example.sop_credit_assessment.repositories.ApplicationRepository;
import com.example.sop_credit_assessment.services.ApplicationService;
import com.example.sop_credit_assessment.services.ClientService;
import com.example.sop_credit_assessment.services.CreditCheckRequestSender;
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
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository applicationRepository;
    private ClientService clientService;
    private CreditCheckRequestSender creditCheckRequestSender;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public ApplicationServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Autowired
    public void setApplicationRepository(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setCreditCheckRequestSender(CreditCheckRequestSender creditCheckRequestSender) {
        this.creditCheckRequestSender = creditCheckRequestSender;
    }

    @Override
    public void createApplication(ApplicationCreationRequest applicationCreationRequest) {
        if (!this.validationUtil.isValid(applicationCreationRequest)) {

            this.validationUtil
                    .violations(applicationCreationRequest)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            throw new IllegalArgumentException("Illegal argument!");
        }
        Application application = modelMapper.map(applicationCreationRequest, Application.class);
        application.setCreated(LocalDateTime.now());
        application.setApplicationStatus(ApplicationStatus.REVIEWING);
        Client client = clientService.findClientById(applicationCreationRequest.getClient()).orElseThrow();
        application.setClient(client);
        this.applicationRepository.save(application);
        creditCheckRequestSender.sendCreditCheckRequest(new CreditCheckRequestMessage(
                client.getCif(), client.getAge(), client.getAnnualIncome(), client.getTotalMonthlyDebtPayment(), client.getEmploymentStatus(),
                application.getId().toString(), application.getAmount(), application.getPurpose(), application.getTerm()));
    }

    @Override
    public ApplicationDto updateStatus(UUID uuid, ApplicationStatus status) {
        Optional<Application> application = applicationRepository.findById(uuid);
        if (application.isEmpty()) {
            throw new EntityNotFoundException("Пользователя с таким ID нет: " + uuid);
        }
        application.get().setApplicationStatus(status);
        application.get().setModified(LocalDateTime.now());
        return modelMapper.map(this.applicationRepository.save(application.get()), ApplicationDto.class);
    }

    @Override
    public ApplicationDto findById(UUID uuid) {
        return modelMapper.map(this.applicationRepository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Заявки с таким ID нет!")), ApplicationDto.class);
    }

    @Override
    public List<ApplicationDto> findAllApplications() {
        return this.applicationRepository
                .findAll()
                .stream()
                .map(application -> modelMapper.map(application, ApplicationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationDto> findAllApplicationsByClient(UUID client_uuid) {
        return this.applicationRepository
                .findAllByClientId(client_uuid)
                .stream()
                .map(application -> modelMapper.map(application, ApplicationDto.class))
                .collect(Collectors.toList());
    }

}
