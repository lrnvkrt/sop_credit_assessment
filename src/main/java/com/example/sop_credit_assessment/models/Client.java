package com.example.sop_credit_assessment.models;

import com.example.sop_credit_assessment.models.converters.EmploymentStatusConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Client extends BaseEntity {

    private String fullName;

    private Integer age;

    private String email;

    private BigDecimal annualIncome;

    @Convert(converter = EmploymentStatusConverter.class)
    private EmploymentStatus employmentStatus;

    public enum EmploymentStatus {
        EMPLOYED(0),
        SELF_EMPLOYED(10),
        UNEMPLOYED(20);

        private int num;

        EmploymentStatus(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

    }

    protected Client() {}

    public Client(String fullName, Integer age, String email, BigDecimal annualIncome, EmploymentStatus employmentStatus) {
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

    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(EmploymentStatus employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

}
