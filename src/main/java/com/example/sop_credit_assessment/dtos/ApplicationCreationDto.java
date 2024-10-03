package com.example.sop_credit_assessment.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public class ApplicationCreationDto extends BaseEntityDto {

    private BigDecimal amount;

    private String purpose;

    private Integer term;

    private UUID client;

    protected ApplicationCreationDto() {}

    public ApplicationCreationDto(BigDecimal amount,
                                  String purpose,
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
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
