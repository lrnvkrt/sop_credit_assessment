package com.example.sop_credit_assessment.api.rest.hateoas.assembler;

import com.example.sop_credit_assessment.api.rest.controllers.ApplicationController;
import com.example.sop_credit_assessment.api.rest.controllers.ClientController;
import com.example.sop_credit_assessment.api.rest.hateoas.model.ClientModel;
import com.example.sop_credit_assessment.dtos.ClientDto;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ClientAssembler extends RepresentationModelAssemblerSupport<ClientDto, ClientModel> {

    public ClientAssembler() {
        super(ClientController.class, ClientModel.class);
    }

    @Override
    @NonNull
    public ClientModel toModel(@NonNull ClientDto entity) {
        ClientModel model = createModelWithId(entity.getId(), entity);
        model.add(linkTo(methodOn(ApplicationController.class)
                .getApplicationsByClient(entity.getId()))
                .withRel("applications"));

        model.add(linkTo(methodOn(ClientController.class)
                .updateClient(null))
                .withRel("update")
                .withType("POST")
                .andAffordance(afford(methodOn(ClientController.class)
                        .updateClient(null))));

        model.setAge(entity.getAge());
        model.setEmail(entity.getEmail());
        model.setAnnualIncome(entity.getAnnualIncome());
        model.setFullName(entity.getFullName());
        model.setEmploymentStatus(entity.getEmploymentStatus());

        return model;
    }
}
