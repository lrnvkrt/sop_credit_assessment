package com.example.sop_credit_assessment.dtos;

import com.example.sop_credit_assessment.models.Application;

import java.math.BigDecimal;
import java.util.UUID;

public class ApplicationCreationDto extends BaseEntityDto {

    private BigDecimal amount;

    private Application.Purpose purpose;

    private Integer term;

    private UUID client;

    protected ApplicationCreationDto() {}

    public ApplicationCreationDto(BigDecimal amount,
                                  Application.Purpose purpose,
                                  Integer term,
                                  UUID client) {
        this.amount = amount;
        this.purpose = purpose;
        this.term = term;
        this.client = client;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Application.Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Application.Purpose purpose) {
        this.purpose = purpose;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public UUID getClient() {
        return client;
    }

    public void setClient(UUID client) {
        this.client = client;
    }
}
