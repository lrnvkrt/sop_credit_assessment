package com.example.sop_credit_assessment.init;

import com.example.sop_credit_assessment.dtos.ClientDto;
import com.example.sop_credit_assessment.init.factories.ClientFactory;
import com.example.sop_credit_assessment.services.impl.ApplicationServiceImpl;
import com.example.sop_credit_assessment.services.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private ClientServiceImpl clientService;
    private ApplicationServiceImpl applicationService;
    private final ClientFactory clientFactory;

    public DataInitializer(ClientFactory clientFactory) { this.clientFactory = clientFactory; }

    @Autowired
    public void setApplicationService(ApplicationServiceImpl applicationService) {
        this.applicationService = applicationService;
    }

    @Autowired
    public void setClientService(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @Override
    public void run(String... args) {
        clientFactory.addClients(1000).forEach(clientDto -> clientService.addClient(clientDto));
        List<ClientDto> clientDtos = clientService.findAllClients();
        for (ClientDto clientDto : clientDtos) {
            clientFactory.createApplications(clientFactory.getRandomQuantity(10), clientDto.getId()).forEach(a -> applicationService.createApplication(a));
        }
        System.out.println(clientService.findAllClients());
        System.out.println(applicationService.findAllApplications());
    }
}
