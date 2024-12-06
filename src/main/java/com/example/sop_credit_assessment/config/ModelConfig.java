package com.example.sop_credit_assessment.config;

import com.example.sop_contracts.requests.ApplicationCreationRequest;
import com.example.sop_credit_assessment.dtos.ApplicationDto;
import com.example.sop_credit_assessment.models.Application;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Application, ApplicationCreationRequest> applicationCreationDtoPropertyMapper = modelMapper.createTypeMap(Application.class, ApplicationCreationRequest.class);
        applicationCreationDtoPropertyMapper.addMapping(
                application -> application.getClient().getId(), ApplicationCreationRequest::setClient
        );
        TypeMap<Application, ApplicationDto> applicationDtoPropertyMapper = modelMapper.createTypeMap(Application.class, ApplicationDto.class);
        applicationDtoPropertyMapper.addMapping(
                application -> application.getClient().getId(), ApplicationDto::setClient
        );
        return modelMapper;
    }
}
