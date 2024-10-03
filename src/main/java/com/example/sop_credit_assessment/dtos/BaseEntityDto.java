package com.example.sop_credit_assessment.dtos;

import java.util.UUID;

public abstract class BaseEntityDto {
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
