package com.example.sop_credit_assessment.api.rest.hateoas.assembler;

import com.example.sop_contracts.models.ApplicationModel;
import com.example.sop_credit_assessment.api.rest.controllers.ApplicationController;
import com.example.sop_credit_assessment.api.rest.controllers.ClientController;

import com.example.sop_credit_assessment.dtos.ApplicationDto;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ApplicationAssembler extends RepresentationModelAssemblerSupport<ApplicationDto, ApplicationModel> {

    public ApplicationAssembler() {
        super(ApplicationController.class, ApplicationModel.class);
    }

    @Override
    @NonNull
    public ApplicationModel toModel(@NonNull ApplicationDto entity) {
        ApplicationModel model = createModelWithId(entity.getId(), entity);
        model.add(linkTo(methodOn(ClientController.class).findClientById(entity.getClient())).withRel("client"));
        model.setAmount(entity.getAmount());
        model.setPurpose(entity.getPurpose());
        model.setTerm(entity.getTerm());
        model.setApplicationStatus(entity.getApplicationStatus());
        return model;
    }
}
