package com.example.sop_credit_assessment.records.messages;

import com.example.sop_contracts.enumerations.EmploymentStatus;
import com.example.sop_contracts.enumerations.Purpose;

import java.io.Serializable;
import java.math.BigDecimal;

public record CreditCheckRequestMessage(
        String cif,
        Integer age,
        BigDecimal annualIncome,
        BigDecimal totalMonthlyDebtPayment,
        EmploymentStatus employmentStatus,
        String referenceId,
        BigDecimal amount,
        Purpose purpose,
        Integer term
) implements Serializable {}
