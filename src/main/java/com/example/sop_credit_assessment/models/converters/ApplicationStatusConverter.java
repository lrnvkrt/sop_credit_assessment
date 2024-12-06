package com.example.sop_credit_assessment.models.converters;

import com.example.sop_contracts.enumerations.ApplicationStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ApplicationStatusConverter implements AttributeConverter<ApplicationStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ApplicationStatus applicationStatus) {
        if (applicationStatus == null) {
            return null;
        }
        return applicationStatus.getNum();
    }

    @Override
    public ApplicationStatus convertToEntityAttribute(Integer integer) {
        ApplicationStatus[] applicationStatuses = ApplicationStatus.class.getEnumConstants();
        for (ApplicationStatus applicationStatus: applicationStatuses) {
            if (applicationStatus.getNum() == integer) {
                return applicationStatus;
            }
        }
        return null;
    }
}
