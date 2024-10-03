package com.example.sop_credit_assessment.models.converters;

import com.example.sop_credit_assessment.models.Application;
import com.example.sop_credit_assessment.models.Client;
import jakarta.persistence.AttributeConverter;

public class ApplicationStatusConverter implements AttributeConverter<Application.ApplicationStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Application.ApplicationStatus applicationStatus) {
        if (applicationStatus == null) {
            return null;
        }
        return applicationStatus.getNum();
    }

    @Override
    public Application.ApplicationStatus convertToEntityAttribute(Integer integer) {
        Application.ApplicationStatus[] applicationStatuses = Application.ApplicationStatus.class.getEnumConstants();
        for (Application.ApplicationStatus applicationStatus: applicationStatuses) {
            if (applicationStatus.getNum() == integer) {
                return applicationStatus;
            }
        }
        return null;
    }
}
