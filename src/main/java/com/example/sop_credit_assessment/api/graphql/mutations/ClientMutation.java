package com.example.sop_credit_assessment.api.graphql.mutations;


import com.example.sop_credit_assessment.dtos.ClientDto;
import com.example.sop_credit_assessment.records.graphql.CreateClientInput;
import com.example.sop_credit_assessment.records.graphql.UpdateClientInput;
import com.example.sop_credit_assessment.services.ClientService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;

import java.math.BigDecimal;
import java.util.UUID;

@DgsComponent
public class ClientMutation {

    private final ClientService clientService;

    public ClientMutation(ClientService clientService) {
        this.clientService = clientService;
    }

    @DgsMutation
    public Boolean createClient(@InputArgument("input") CreateClientInput createClientInput) {
        clientService.addClient(new ClientDto(createClientInput.cif(),
                                                createClientInput.fullName(),
                                                createClientInput.age(),
                                                createClientInput.email(),
                                                new BigDecimal(createClientInput.annualIncome()),
                                                new BigDecimal(createClientInput.totalMonthlyDebtPayment()),
                                                createClientInput.employmentStatus()));
        return true;
    }

    @DgsMutation
    public ClientDto updateClient(@InputArgument("input") UpdateClientInput updateClientInput) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(UUID.fromString(updateClientInput.id()));
        clientDto.setCif(updateClientInput.cif());
        clientDto.setFullName(updateClientInput.fullName());
        clientDto.setAge(updateClientInput.age());
        clientDto.setEmail(updateClientInput.email());
        clientDto.setAnnualIncome(new BigDecimal(updateClientInput.annualIncome()));
        clientDto.setTotalMonthlyDebtPayment(new BigDecimal(updateClientInput.totalMonthlyDebtPayment()));
        clientDto.setEmploymentStatus(updateClientInput.employmentStatus());
        return clientService.updateClient(clientDto);
    }
}
