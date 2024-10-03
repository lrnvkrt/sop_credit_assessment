package com.example.sop_credit_assessment.config;

import com.example.sop_credit_assessment.dtos.ApplicationCreationDto;
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
        TypeMap<Application, ApplicationCreationDto> applicationCreationDtoPropertyMapper = modelMapper.createTypeMap(Application.class, ApplicationCreationDto.class);
        applicationCreationDtoPropertyMapper.addMapping(
                application -> application.getClient().getId(), ApplicationCreationDto::setClient
        );
        TypeMap<Application, ApplicationDto> applicationDtoPropertyMapper = modelMapper.createTypeMap(Application.class, ApplicationDto.class);
        applicationDtoPropertyMapper.addMapping(
                application -> application.getClient().getId(), ApplicationDto::setClient
        );
        return modelMapper;
    }
}
