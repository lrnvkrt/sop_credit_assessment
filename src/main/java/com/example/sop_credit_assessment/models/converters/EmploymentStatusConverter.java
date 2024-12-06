package com.example.sop_credit_assessment.models.converters;

import com.example.sop_contracts.enumerations.EmploymentStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EmploymentStatusConverter implements AttributeConverter<EmploymentStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(EmploymentStatus employmentStatus) {
        if (employmentStatus == null) {
            return null;
        }
        return employmentStatus.getNum();
    }

    @Override
    public EmploymentStatus convertToEntityAttribute(Integer integer) {
        EmploymentStatus[] employmentStatuses = EmploymentStatus.class.getEnumConstants();
        for (EmploymentStatus employmentStatus: employmentStatuses) {
            if (employmentStatus.getNum() == integer) {
                return employmentStatus;
            }
        }
        return null;
    }
}
