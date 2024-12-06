package com.example.sop_credit_assessment.api.graphql.datafetchers;

import com.example.sop_contracts.requests.ClientRequest;
import com.example.sop_credit_assessment.dtos.ApplicationDto;
import com.example.sop_credit_assessment.services.ApplicationService;
import com.netflix.graphql.dgs.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@DgsComponent
public class ApplicationDataFetcher {

    private final ApplicationService applicationService;

    public ApplicationDataFetcher(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @DgsQuery
    public List<ApplicationDto> getAllApplications() {
        return applicationService.findAllApplications();
    }

    @DgsQuery
    public ApplicationDto getApplication(@InputArgument String id) {
        UUID applicationId = UUID.fromString(Objects.requireNonNull(id));
        return applicationService.findById(applicationId);
    }

    @DgsData(parentType = "Client", field = "applications")
    public List<ApplicationDto> getApplicationsByClient(@NotNull DgsDataFetchingEnvironment ddfe) {
        ClientRequest clientDto = ddfe.getSource();
        return applicationService.findAllApplicationsByClient(Objects.requireNonNull(clientDto).getId());
    }
}
