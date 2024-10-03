package com.example.sop_credit_assessment.models.converters;

import com.example.sop_credit_assessment.models.Client;
import jakarta.persistence.AttributeConverter;

public class EmploymentStatusConverter implements AttributeConverter<Client.EmploymentStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Client.EmploymentStatus employmentStatus) {
        if (employmentStatus == null) {
            return null;
        }
        return employmentStatus.getNum();
    }

    @Override
    public Client.EmploymentStatus convertToEntityAttribute(Integer integer) {
        Client.EmploymentStatus[] employmentStatuses = Client.EmploymentStatus.class.getEnumConstants();
        for (Client.EmploymentStatus employmentStatus: employmentStatuses) {
            if (employmentStatus.getNum() == integer) {
                return employmentStatus;
            }
        }
        return null;
    }
}
