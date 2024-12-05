package com.example.sop_credit_assessment.dtos;

import com.example.sop_credit_assessment.models.Application;

import java.math.BigDecimal;
import java.util.UUID;

public class ApplicationDto extends ApplicationCreationDto{

    private Application.ApplicationStatus applicationStatus;

    protected ApplicationDto() {}

    public ApplicationDto(BigDecimal amount, Application.Purpose purpose, Integer term, UUID client, Application.ApplicationStatus applicationStatus) {
        super(amount, purpose, term, client);
        this.applicationStatus = applicationStatus;
    }

    public Application.ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(Application.ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
