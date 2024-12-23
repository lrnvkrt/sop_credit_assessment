package com.example.sop_credit_assessment.api.rest.controllers;

import com.example.sop_contracts.models.ApplicationModel;
import com.example.sop_contracts.requests.ApplicationCreationRequest;
import com.example.sop_credit_assessment.api.rest.hateoas.assembler.ApplicationAssembler;
import com.example.sop_credit_assessment.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:8083")
@RequestMapping("/applications")
public class ApplicationController implements com.example.sop_contracts.controllers.ApplicationController {

    private ApplicationService applicationService;

    private ApplicationAssembler applicationAssembler;

    @Autowired
    public void setApplicationAssembler(ApplicationAssembler applicationAssembler) {
        this.applicationAssembler = applicationAssembler;
    }

    @Autowired
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/add")
    @Override
    public void addApplication(@RequestBody ApplicationCreationRequest applicationCreationRequest) {
        applicationService.createApplication(applicationCreationRequest);
    }

    @GetMapping("/{id}")
    @Override
    public ApplicationModel getApplication(@PathVariable UUID id) {
        return applicationAssembler.toModel(applicationService.findById(id));
    }

    @GetMapping("/client/{id}")
    @Override
    public CollectionModel<ApplicationModel> getAllApplicationsByClient(@PathVariable UUID id) {
        return applicationAssembler.toCollectionModel(applicationService.findAllApplicationsByClient(id));
    }

    @GetMapping("/all")
    @Override
    public CollectionModel<ApplicationModel> getAllApplications() {
        return applicationAssembler.toCollectionModel(applicationService.findAllApplications());
    }
}
