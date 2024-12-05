package com.example.sop_credit_assessment.api.rest.controllers;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping
    public RepresentationModel<?> getApi() {
        RepresentationModel<?> model = new RepresentationModel<>();

        model.add(linkTo(methodOn(ApiController.class).getApi()).withSelfRel());
        model.add(linkTo(methodOn(ApplicationController.class).getAllApplications()).withRel("all applications"));
        model.add(linkTo(methodOn(ClientController.class).getAllClients()).withRel("all clients"));

        return model;
    }
}
