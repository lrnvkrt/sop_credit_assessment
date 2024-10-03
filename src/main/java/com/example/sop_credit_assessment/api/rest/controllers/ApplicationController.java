package com.example.sop_credit_assessment.api.rest.controllers;

import com.example.sop_credit_assessment.api.rest.hateoas.assembler.ApplicationAssembler;
import com.example.sop_credit_assessment.api.rest.hateoas.model.ApplicationModel;
import com.example.sop_credit_assessment.dtos.ApplicationCreationDto;
import com.example.sop_credit_assessment.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

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
    void addApplication(@RequestBody ApplicationCreationDto applicationCreationDto) {
        applicationService.createApplication(applicationCreationDto);
    }

    @GetMapping("/{id}")
    public ApplicationModel getApplication(@PathVariable UUID id) {
        return applicationAssembler.toModel(applicationService.findById(id));
    }

    @GetMapping("/client/{id}")
    public CollectionModel<ApplicationModel> getApplicationsByClient(@PathVariable UUID id) {
        return applicationAssembler.toCollectionModel(applicationService.findAllApplicationsByClient(id));
    }

    @GetMapping("/all")
    public CollectionModel<ApplicationModel> getAllApplications() {
        return applicationAssembler.toCollectionModel(applicationService.findAllApplications());
    }
}
