package com.example.sop_credit_assessment.models;

import com.example.sop_contracts.enumerations.EmploymentStatus;
import com.example.sop_credit_assessment.models.converters.EmploymentStatusConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Client extends BaseEntity {

    private String cif;

    private String fullName;

    private Integer age;

    private String email;

    private BigDecimal annualIncome;

    private BigDecimal totalMonthlyDebtPayment;

    @Convert(converter = EmploymentStatusConverter.class)
    private EmploymentStatus employmentStatus;


    protected Client() {}

    public Client(String cif, String fullName, Integer age, String email, BigDecimal annualIncome, BigDecimal totalMonthlyDebtPayment, EmploymentStatus employmentStatus) {
        this.cif = cif;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.annualIncome = annualIncome;
        this.totalMonthlyDebtPayment = totalMonthlyDebtPayment;
        this.employmentStatus = employmentStatus;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
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

    public BigDecimal getTotalMonthlyDebtPayment() {
        return totalMonthlyDebtPayment;
    }

    public void setTotalMonthlyDebtPayment(BigDecimal totalMonthlyDebtPayment) {
        this.totalMonthlyDebtPayment = totalMonthlyDebtPayment;
    }

    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(EmploymentStatus employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

}
