package com.example.sop_credit_assessment.api.graphql.mutations;


import com.example.sop_contracts.requests.ApplicationCreationRequest;
import com.example.sop_credit_assessment.records.graphql.CreateApplicationInput;
import com.example.sop_credit_assessment.services.ApplicationService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;

import java.math.BigDecimal;
import java.util.UUID;

@DgsComponent
public class ApplicationMutation {

    private final ApplicationService applicationService;

    public ApplicationMutation(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    
    @DgsMutation
    public Boolean createApplication(@InputArgument("input") CreateApplicationInput createApplicationInput) {
        applicationService.createApplication(new ApplicationCreationRequest(new BigDecimal(createApplicationInput.amount()), createApplicationInput.purpose(), createApplicationInput.term(), UUID.fromString(createApplicationInput.client())));
        return true;
    }
}
