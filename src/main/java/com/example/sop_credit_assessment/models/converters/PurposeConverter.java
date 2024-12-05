package com.example.sop_credit_assessment.models.converters;

import com.example.sop_credit_assessment.models.Application;
import jakarta.persistence.AttributeConverter;

public class PurposeConverter implements AttributeConverter<Application.Purpose, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Application.Purpose purpose) {
        if (purpose == null) {
            return null;
        }
        return purpose.getNum();
    }

    @Override
    public Application.Purpose convertToEntityAttribute(Integer integer) {
        Application.Purpose[] purposes = Application.Purpose.class.getEnumConstants();
        for (Application.Purpose purpose: purposes) {
            if (purpose.getNum() == integer) {
                return purpose;
            }
        }
        return null;
    }

}
