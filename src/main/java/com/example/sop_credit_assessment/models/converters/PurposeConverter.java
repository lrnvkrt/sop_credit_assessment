package com.example.sop_credit_assessment.models.converters;

import com.example.sop_contracts.enumerations.Purpose;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PurposeConverter implements AttributeConverter<Purpose, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Purpose purpose) {
        if (purpose == null) {
            return null;
        }
        return purpose.getNum();
    }

    @Override
    public Purpose convertToEntityAttribute(Integer integer) {
        Purpose[] purposes = Purpose.class.getEnumConstants();
        for (Purpose purpose: purposes) {
            if (purpose.getNum() == integer) {
                return purpose;
            }
        }
        return null;
    }

}
