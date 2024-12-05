package com.example.sop_credit_assessment.records.messages;

import com.example.sop_credit_assessment.models.Application;
import com.example.sop_credit_assessment.models.Client;

import java.io.Serializable;
import java.math.BigDecimal;

public record CreditCheckRequestMessage(
        String cif,
        Integer age,
        BigDecimal annualIncome,
        BigDecimal totalMonthlyDebtPayment,
        Client.EmploymentStatus employmentStatus,
        String referenceId,
        BigDecimal amount,
        Application.Purpose purpose,
        Integer term
) implements Serializable {}
