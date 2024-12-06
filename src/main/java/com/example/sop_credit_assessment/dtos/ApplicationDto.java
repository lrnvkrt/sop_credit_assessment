package com.example.sop_credit_assessment.dtos;

import com.example.sop_contracts.enumerations.ApplicationStatus;
import com.example.sop_contracts.enumerations.Purpose;
import com.example.sop_contracts.requests.ApplicationCreationRequest;

import java.math.BigDecimal;
import java.util.UUID;

public class ApplicationDto extends ApplicationCreationRequest {

    private ApplicationStatus applicationStatus;

    protected ApplicationDto() {}

    public ApplicationDto(BigDecimal amount, Purpose purpose, Integer term, UUID client, ApplicationStatus applicationStatus) {
        super(amount, purpose, term, client);
        this.applicationStatus = applicationStatus;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
