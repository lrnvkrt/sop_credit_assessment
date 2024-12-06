package com.example.sop_credit_assessment.models;

import com.example.sop_contracts.enumerations.ApplicationStatus;
import com.example.sop_contracts.enumerations.Purpose;
import com.example.sop_credit_assessment.models.converters.ApplicationStatusConverter;
import com.example.sop_credit_assessment.models.converters.PurposeConverter;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Application extends BaseEntity{

    private BigDecimal amount;

    @Convert(converter = PurposeConverter.class)
    private Purpose purpose;

    private Integer term;

    @Convert(converter = ApplicationStatusConverter.class)
    private ApplicationStatus applicationStatus;


    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Client client;

    protected Application() {}

    public Application(BigDecimal amount, Purpose purpose, Integer term, ApplicationStatus applicationStatus, Client client) {
        this.amount = amount;
        this.purpose = purpose;
        this.term = term;
        this.applicationStatus = applicationStatus;
        this.client = client;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
