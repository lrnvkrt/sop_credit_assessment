package com.example.sop_credit_assessment.api.graphql.datafetchers;


import com.example.sop_contracts.requests.ClientRequest;
import com.example.sop_credit_assessment.dtos.ApplicationDto;
import com.example.sop_credit_assessment.services.ClientService;
import com.netflix.graphql.dgs.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@DgsComponent
public class ClientDataFetcher {

    private final ClientService clientService;

    public ClientDataFetcher(ClientService clientService) {
        this.clientService = clientService;
    }

    @DgsQuery
    public List<ClientRequest> getAllClients() {
        return clientService.findAllClients();
    }

    @DgsQuery
    public ClientRequest getClient(@InputArgument String id) {
        UUID clientId = UUID.fromString(Objects.requireNonNull(id));
        return clientService.findClientDtoById(clientId);
    }

    @DgsData(parentType = "Application", field = "client")
    public ClientRequest getClientByApplication(DgsDataFetchingEnvironment ddfe) {
        ApplicationDto applicationDto = ddfe.getSource();
        return clientService.findClientDtoById(Objects.requireNonNull(applicationDto).getClient());
    }
}
