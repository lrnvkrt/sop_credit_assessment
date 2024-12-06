package com.example.sop_credit_assessment.services;

import com.example.sop_contracts.enumerations.ApplicationStatus;
import com.example.sop_contracts.requests.ApplicationCreationRequest;
import com.example.sop_credit_assessment.dtos.ApplicationDto;
import com.example.sop_credit_assessment.models.Application;

import java.util.List;
import java.util.UUID;

public interface ApplicationService {

    void createApplication(ApplicationCreationRequest applicationCreationRequest);

    ApplicationDto updateStatus(UUID uuid, ApplicationStatus status);

    ApplicationDto findById(UUID uuid);

    List<ApplicationDto> findAllApplications();

    List<ApplicationDto> findAllApplicationsByClient(UUID client_uuid);
}
