package com.example.sop_credit_assessment.api.rest.hateoas.model;

import com.example.sop_credit_assessment.models.Application;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

public class ApplicationModel extends RepresentationModel<ApplicationModel> {

    private BigDecimal amount;

    private String purpose;

    private Integer term;

    private Application.ApplicationStatus applicationStatus;

    protected ApplicationModel() {}

    public ApplicationModel(BigDecimal amount,
                            String purpose,
                            Integer term,
                            Application.ApplicationStatus applicationStatus) {
        this.amount = amount;
        this.purpose = purpose;
        this.term = term;
        this.applicationStatus = applicationStatus;
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

    public Application.ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(Application.ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
