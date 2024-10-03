package com.example.sop_credit_assessment.models;

import com.example.sop_credit_assessment.models.converters.ApplicationStatusConverter;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
public class Application extends BaseEntity{

    private BigDecimal amount;

    private String purpose;

    private Integer term;

    @Convert(converter = ApplicationStatusConverter.class)
    private ApplicationStatus applicationStatus;

    public enum ApplicationStatus {
        REVIEWING(0),
        APPROVED(10),
        REJECTED(20);

        private int num;

        ApplicationStatus(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Client client;

    protected Application() {}

    public Application(BigDecimal amount, String purpose, Integer term, ApplicationStatus applicationStatus, Client client) {
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
