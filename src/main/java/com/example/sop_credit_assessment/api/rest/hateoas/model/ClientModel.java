package com.example.sop_credit_assessment.api.rest.hateoas.model;

import com.example.sop_credit_assessment.models.Client;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

public class ClientModel extends RepresentationModel<ClientModel> {

    private String fullName;

    private Integer age;

    private String email;

    private BigDecimal annualIncome;

    private Client.EmploymentStatus employmentStatus;

    protected ClientModel() {}

    public ClientModel(String fullName,
                       Integer age,
                       String email,
                       BigDecimal annualIncome,
                       Client.EmploymentStatus employmentStatus) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.annualIncome = annualIncome;
        this.employmentStatus = employmentStatus;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(BigDecimal annualIncome) {
        this.annualIncome = annualIncome;
    }

    public Client.EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(Client.EmploymentStatus employmentStatus) {
        this.employmentStatus = employmentStatus;
    }
}
